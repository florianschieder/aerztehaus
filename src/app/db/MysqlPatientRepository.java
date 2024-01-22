package app.db;

import java.sql.SQLException;

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
    public void insert(Patient e) throws SQLException
    {
        String query = String.format(
            "INSERT INTO Patient "
                + "VALUES(%d, '%s', '%s', '%s', '%s', '%s')",
                e.getId(),
                e.getPrename(),
                e.getSurname(),
                e.getStreet(),
                e.getZipCode(),
                e.getCity());
        this.manager.executeUpdate(query);
    }
}