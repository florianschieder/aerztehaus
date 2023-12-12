package app;

import javax.swing.JOptionPane;

import app.core.BillRecord;
import app.core.Patient;
import app.db.MysqlBillRecordRepository;
import app.db.MysqlPatientRepository;
import app.ui.AddPatientController;
import app.ui.HomeController;
import common.db.core.DBManager;
import common.db.repository.ReadRepository;
import common.db.repository.WriteRepository;

public class App
{
    private ReadRepository<BillRecord> billRecordRepository;
    private WriteRepository<Patient> patientRepository;

    public App(DBManager manager)
    {
        this.billRecordRepository = new MysqlBillRecordRepository(manager);
        this.patientRepository = new MysqlPatientRepository(manager);
    }

    public void startApp()
    {
        HomeController controller = new HomeController(this);
        controller.run();
    }

    public void runAddPatientController()
    {
        AddPatientController controller =
            new AddPatientController(this.patientRepository);
        controller.run();
    }

    public void exportRecords()
    {
        BillRecordExporter exporter =
            new BillRecordExporter(this.billRecordRepository);
        try {
            exporter.run();
        }
        catch (Exception e) {
            // TODO duplicate code
            JOptionPane.showMessageDialog(
                null,
                e.toString(),
                "Patientenverwaltung - Fehler",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}