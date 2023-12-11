package common.db;

public interface Repository<Entity>
{
    Iterable<Entity> fetchAll();
}