package common.db.core;

import java.sql.Connection;


final class ConnectionHandle
{
    private ConnectionState state;

    public ConnectionHandle(final ConnectionState state)
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