package app.repository;

import app.core.BillRecord;
import common.db.repository.Repository;

public interface BillRecordRepository extends Repository
{
	public Iterable<BillRecord> fetchAll() throws Exception;
}