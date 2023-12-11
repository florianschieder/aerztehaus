package common.db.core;

@SuppressWarnings("serial")
public class ManagerInitializationFailedException extends Exception
{
    public ManagerInitializationFailedException(String cause)
    {
        super(cause);
    }
}