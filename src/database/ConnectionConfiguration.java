package database;

public class ConnectionConfiguration
{
    private String dbType;
    private String url;
    private int port;
    private String username;
    private String password;
    private String database;

    public ConnectionConfiguration(
        String dbType,
        String url,
        int port,
        String username,
        String password,
        String database)
    {
        this.dbType = dbType;
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
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
}