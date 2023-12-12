package common.db.repository;

public interface WriteRepository<Entity>
extends Repository<Entity>
{
    void insert(Entity e) throws Exception;
}