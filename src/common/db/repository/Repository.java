package common.db.repository;

/**
 * Generic empty repository interface.
 * 
 * The purpose of any repository is encapsulating reading or writing
 * access to any entity.
 * 
 * This base interface is only here for convenience because there may
 * parts of generic code and you cannot tell if entities are both supposed
 * to be loaded and stored or only loaded or stored.
 */
public interface Repository {}