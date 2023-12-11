package common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class ConnectionState
{
    private boolean isUsed = false;
    private Connection connection = null;

    public ConnectionState(ConnectionConfiguration conf)
        throws SQLException
    {
        this.connection =
            DriverManager
            .getConnection(conf.getURL(),
                conf.getUser(),
                conf.getPassword());
        this.connection
        .createStatement()
        .execute(String.format("USE %s;", conf.getDatabase()));
    }

    @Override
    public void finalize()
    {
        try {
            this.connection.close();
        }
        catch (SQLException e) {}
    }

    public Connection allocateConnection()
        throws ConnectionInUseException
    {
        if (this.isUsed)
            throw new ConnectionInUseException();

        this.isUsed = true;
        return this.connection;
    }

    public void freeConnection()
    {
        this.isUsed = false;
    }
}