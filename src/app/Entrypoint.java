package app;

import common.db.core.DBManager;
import common.db.mysql.MysqlConnectionConfiguration;


public class Entrypoint
{
    public static void main(String[] args)
    {
        try {
            DBManager manager =
                deriveConfigurationFromCommandLine(args)
                .intoDBManager();
            App app = new App(manager);
            app.startApp();
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