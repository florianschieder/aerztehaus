package app;

import app.db.MysqlBillRecordRepository;
import app.db.MysqlPatientRepository;
import app.ui.AddPatientController;
import common.db.core.DBManager;
import common.db.mysql.MysqlConnectionConfiguration;


public class Entrypoint
{
    public static void main(String[] args)
    {
        try {
            MysqlConnectionConfiguration configuration =
                deriveConfigurationFromCommandLine(args);
            DBManager manager = new DBManager(configuration);

            // TODO: yet unused
            MysqlBillRecordRepository billRepository =
                new MysqlBillRecordRepository(manager);

            MysqlPatientRepository patientRepository =
                new MysqlPatientRepository(manager);

            AddPatientController controller =
                new AddPatientController(patientRepository);
            controller.run();
        }
        catch (Exception e) {
            System.err.println("exiting due to uncaught failure: " + e);
            System.exit(1);
        }
    }

    private static MysqlConnectionConfiguration
    deriveConfigurationFromCommandLine(String[] args)
    {
        try {
            return new MysqlConnectionConfiguration(
                args[0],
                args[1],
                args[2],
                args[3]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(
                "required parameters: "
                    + "DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE");
        }
    }
}