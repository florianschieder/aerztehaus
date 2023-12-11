package common.db;

import java.sql.Connection;
import java.sql.SQLException;

class ConnectionPool
{
    private ConnectionState[] connections;

    public ConnectionPool(int capacity, ConnectionConfiguration configuration)
        throws SQLException
    {
        this.connections = new ConnectionState[capacity];

        for (int i = 0; i < capacity; i++)
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