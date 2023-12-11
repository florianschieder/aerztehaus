package common.db.repository;

public interface ReadWriteRepository<Entity>
extends WriteRepository<Entity>, ReadRepository<Entity>
{
}