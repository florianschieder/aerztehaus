package app.core;

import common.db.core.DBManager;
import common.db.mysql.MysqlConnectionConfiguration;


public class Entrypoint
{
	private final static int DB_POOL_SIZE = 1;
	
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
        // keep this consistent with the README file
        try {
            return new MysqlConnectionConfiguration(
                args[0],
                args[1],
                args[2],
                args[3],
                DB_POOL_SIZE);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(
                "required parameters: "
                    + "DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE");
        }
    }
}