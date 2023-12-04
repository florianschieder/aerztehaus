package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBManager;
import database.Repository;


public class MysqlBillRecordRepository
	implements Repository<BillRecord>
{
	private DBManager manager;
	
	public MysqlBillRecordRepository(DBManager manager)
	{
		this.manager = manager;
	}
	
	@Override
	public Iterable<BillRecord> fetchAll()
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
		
		try {
			ResultSet resultSet = this.manager.executeQuery(query);
			
			while (resultSet.next()) {
				records.add(
					new BillRecord(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDouble(4)));
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(
				"could not fetch records: " + e.toString());
		}
		return records;
	}
}