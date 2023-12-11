package common.db;

public class MysqlConnectionConfiguration
extends ConnectionConfiguration
{
    public MysqlConnectionConfiguration(
        String url,
        String username,
        String password,
        String database)
    {
        super("mysql", url, 3306, username, password, database);
    }
}