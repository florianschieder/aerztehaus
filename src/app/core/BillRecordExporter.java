package app.core;

import app.repository.BillRecordRepository;

public class BillRecordExporter
{
    private BillRecordRepository repository;

    public BillRecordExporter(BillRecordRepository repository)
    {
        this.repository = repository;
    }

    public void run() throws Exception
    {
		for (BillRecord record : this.repository.fetchAll()) {
		    System.out.println(record.toString());
		}
        
        throw new RuntimeException(
            "printed out something but no clue what to do with that");
    }
}