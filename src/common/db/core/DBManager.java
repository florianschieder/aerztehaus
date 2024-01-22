package common.db.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager
{
    private static int POOL_SIZE = 10;
    private ConnectionPool pool;

    public DBManager(ConnectionConfiguration configuration)
        throws ClassNotFoundException,
        ManagerInitializationFailedException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("could not load drivers");
            throw e;
        }

        try {
            this.pool = new ConnectionPool(POOL_SIZE, configuration);
        }
        catch (SQLException e) {
            throw new ManagerInitializationFailedException(e.toString());
        }
    }

    public ResultSet executeQuery(String query) throws SQLException
    {
        return
            this.prepareStatement()
            .executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException
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