package app.db;

import java.sql.SQLException;

import app.core.Patient;
import app.repository.PatientRepository;
import common.db.core.DBManager;
import common.db.mysql.MysqlRepository;


public class MysqlPatientRepository
extends MysqlRepository
implements PatientRepository
{
    public MysqlPatientRepository(DBManager manager)
    {
        super(manager);
    }

    @Override
    public void insert(Patient patient) throws SQLException
    {
        String query = String.format(
            "INSERT INTO Patient "
                + "VALUES(%d, '%s', '%s', '%s', '%s', '%s')",
                patient.getId(),
                patient.getPrename(),
                patient.getSurname(),
                patient.getStreet(),
                patient.getZipCode(),
                patient.getCity());
        this.manager.executeUpdate(query);
    }
}