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
        String dbType,
        String url,
        int port,
        String username,
        String password,
        String database,
        int capacity)
    {
        this.dbType = dbType;
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        this.capacity = capacity;
    }

    public String getURL()
    {
        return String.format(
            "jdbc:%s://%s:%d",
            this.dbType,
            this.url,
            this.port);
    }

    public String getUser()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getDatabase()
    {
        return this.database;
    }

    public DBManager intoDBManager()
        throws ClassNotFoundException,
        ManagerInitializationFailedException
    {
        return new DBManager(this);
    }

	public int getCapacity()
	{
		return this.capacity;
	}
}