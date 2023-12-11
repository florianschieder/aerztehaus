package common.db.mysql;

import common.db.core.DBManager;
import common.db.repository.ReadRepository;

public abstract class MysqlReadRepository<Entity>
implements ReadRepository<Entity>
{
    protected DBManager manager;

    public MysqlReadRepository(DBManager manager)
    {
        this.manager = manager;
    }
}