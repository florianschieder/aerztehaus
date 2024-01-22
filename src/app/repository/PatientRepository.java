package app.repository;

import app.core.Patient;
import common.db.repository.Repository;

public interface PatientRepository extends Repository
{
	public void insert(Patient patient) throws Exception;
}