package database;

import java.sql.Connection;


class ConnectionHandle
{
    private ConnectionState state;

    public ConnectionHandle(ConnectionState state)
    {
        this.state = state;
    }

    public Connection getConnection()
            throws ConnectionInUseException
    {
        return this.state.allocateConnection();
    }

    @Override
    public void finalize()
    {
        this.state.freeConnection();
    }
}