package common.db.repository;

public interface ReadRepository<Entity>
extends Repository<Entity>
{
    Iterable<Entity> fetchAll();
}