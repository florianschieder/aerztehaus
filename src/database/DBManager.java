package database;

import java.sql.Connection;
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
        Connection connection = this.pool.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}