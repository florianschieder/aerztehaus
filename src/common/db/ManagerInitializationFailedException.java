package common.db;

@SuppressWarnings("serial")
public class ManagerInitializationFailedException extends Exception
{
    public ManagerInitializationFailedException(String cause)
    {
        super(cause);
    }
}