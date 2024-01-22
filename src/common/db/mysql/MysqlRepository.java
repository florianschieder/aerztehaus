package common.db.mysql;

import common.db.core.DBManager;

/**
 * An abstract repository for writing entities into or fetching
 * them from a MySQL database. 
 */
public abstract class MysqlRepository
{
    protected DBManager manager;

    public MysqlRepository(DBManager manager)
    {
        this.manager = manager;
    }
}