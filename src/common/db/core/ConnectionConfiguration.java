package common.db.core;

public class ConnectionConfiguration
{
    private String dbType;
    private String url;
    private int port;
    private String username;
    private String password;
    private String database;
	private int capacity;

    public ConnectionConfiguration(
        final String dbType,
        final String url,
        final int port,
        final String username,
        final String password,
        final String database,
        final int capacity)
    {
        this.dbType = dbType;
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        this.capacity = capacity;
    }

    public final String getURL()
    {
        return String.format(
            "jdbc:%s://%s:%d",
            this.dbType,
            this.url,
            this.port);
    }

    public final String getUser()
    {
        return this.username;
    }

    public final String getPassword()
    {
        return this.password;
    }

    public final String getDatabase()
    {
        return this.database;
    }

    public final DBManager intoDBManager()
        throws ClassNotFoundException,
        ManagerInitializationFailedException
    {
        return new DBManager(this);
    }

	public final int getCapacity()
	{
		return this.capacity;
	}
}