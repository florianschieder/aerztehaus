package app.db;

import app.core.Patient;
import common.db.core.DBManager;
import common.db.mysql.MysqlWriteRepository;


public class MysqlPatientRepository
extends MysqlWriteRepository<Patient>
{
    public MysqlPatientRepository(DBManager manager)
    {
        super(manager);
    }

    @Override
    public void insert(Patient e)
    {
        throw new RuntimeException("not yet implemented");
    }
}