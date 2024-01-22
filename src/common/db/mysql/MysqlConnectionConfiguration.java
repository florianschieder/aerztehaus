package common.db.mysql;

import common.db.core.ConnectionConfiguration;

public class MysqlConnectionConfiguration
extends ConnectionConfiguration
{
    public MysqlConnectionConfiguration(
    	final String url,
    	final String username,
    	final String password,
    	final String database,
    	final int capacity)
    {
        super("mysql", url, 3306, username, password, database, capacity);
    }
}