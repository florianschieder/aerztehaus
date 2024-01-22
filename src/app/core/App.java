package app.core;

import app.db.MysqlBillRecordRepository;
import app.db.MysqlPatientRepository;
import app.repository.BillRecordRepository;
import app.repository.PatientRepository;
import app.ui.AddPatientController;
import app.ui.HomeController;
import common.db.core.DBManager;

public class App
{
    private BillRecordRepository billRecordRepository;
    private PatientRepository patientRepository;

    public App(DBManager manager)
    {
        this.billRecordRepository = new MysqlBillRecordRepository(manager);
        this.patientRepository = new MysqlPatientRepository(manager);
    }

    public void startApp() throws Exception
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

    public void exportRecords() throws Exception
    {
        BillRecordExporter exporter =
            new BillRecordExporter(this.billRecordRepository);
        exporter.run();
    }
}