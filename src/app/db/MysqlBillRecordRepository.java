package app.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.core.BillRecord;
import app.repository.BillRecordRepository;
import common.db.core.DBManager;
import common.db.mysql.MysqlRepository;


public class MysqlBillRecordRepository
extends MysqlRepository
implements BillRecordRepository
{
    public MysqlBillRecordRepository(DBManager manager)
    {
        super(manager);
    }

    @Override
    public Iterable<BillRecord> fetchAll() throws SQLException
    {
        List<BillRecord> records = new ArrayList<>();
        String query =
            "SELECT "
                + "  P.PatientVorname, P.PatientName,"
                + "  ML.Bezeichnung, ML.Preis "
                + "FROM Patient P "
                + "INNER JOIN Pat_MedLeistung PML"
                + "  ON PML.PatientNr = P.PatientenNr "
                + "INNER JOIN MedLeistung ML "
                + "  ON ML.MLeistungNr = PML.MLeistungsNr";

        ResultSet resultSet = this.manager.executeQuery(query);
        while (resultSet.next())
            records.add(new BillRecord(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4)));
        return records;
    }
}