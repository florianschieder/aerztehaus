package common.db.core;

@SuppressWarnings("serial")
public class ManagerInitializationFailedException extends Exception
{
    public ManagerInitializationFailedException(final String cause)
    {
        super(cause);
    }
}