package common.db.core;

import java.sql.Connection;
import java.sql.SQLException;

class ConnectionPool
{
    private ConnectionState[] connections;

    public ConnectionPool(ConnectionConfiguration configuration)
        throws SQLException
    {
    	if (configuration.getCapacity() < 1) {
    		throw new RuntimeException("capacity must be greater or equal to 1");
    	}
    	
        this.connections = new ConnectionState[configuration.getCapacity()];

        for (int i = 0; i < configuration.getCapacity(); i++)
            this.connections[i] = new ConnectionState(configuration);
    }

    public Connection getConnection()
    {
        while (true)
            for (ConnectionState possiblyFreeConnection : this.connections) {
                ConnectionHandle handle =
                    new ConnectionHandle(possiblyFreeConnection);
                try {
                    return handle.getConnection();
                }
                catch (ConnectionInUseException e) {
                    continue;
                }
            }
    }
}