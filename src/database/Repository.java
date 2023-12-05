package database;

public interface Repository<Entity>
{
    Iterable<Entity> fetchAll();
}