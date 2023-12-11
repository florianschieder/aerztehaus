package common.db.mysql;

import common.db.core.DBManager;
import common.db.repository.WriteRepository;

public abstract class MysqlWriteRepository<Entity>
implements WriteRepository<Entity>
{
    protected DBManager manager;

    public MysqlWriteRepository(DBManager manager)
    {
        this.manager = manager;
    }
}