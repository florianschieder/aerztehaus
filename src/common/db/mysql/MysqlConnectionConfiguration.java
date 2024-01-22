package common.db.mysql;

import common.db.core.ConnectionConfiguration;

public class MysqlConnectionConfiguration
extends ConnectionConfiguration
{
    public MysqlConnectionConfiguration(
        String url,
        String username,
        String password,
        String database,
        int capacity)
    {
        super("mysql", url, 3306, username, password, database, capacity);
    }
}