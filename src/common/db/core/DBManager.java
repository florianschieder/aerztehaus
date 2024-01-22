package common.db.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


final public class DBManager
{
    private ConnectionPool pool;

    public DBManager(final ConnectionConfiguration configuration)
        throws ClassNotFoundException,
        ManagerInitializationFailedException
    {
        try {
            this.pool = new ConnectionPool(configuration);
        }
        catch (SQLException e) {
            throw new ManagerInitializationFailedException(e.toString());
        }
    }

    public ResultSet executeQuery(final String query) throws SQLException
    {
        return
            this.prepareStatement()
            .executeQuery(query);
    }

    public void executeUpdate(final String query) throws SQLException
    {
        this.prepareStatement().executeUpdate(query);
    }

    private Statement prepareStatement() throws SQLException
    {
        return
            this.pool
            .getConnection()
            .createStatement();
    }
}