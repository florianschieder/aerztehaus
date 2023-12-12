package app;

import app.core.BillRecord;
import common.db.repository.ReadRepository;

public class BillRecordExporter
{
    private ReadRepository<BillRecord> repository;

    public BillRecordExporter(ReadRepository<BillRecord> repository)
    {
        this.repository = repository;
    }

    public void run() throws Exception
    {
        for (BillRecord record : this.repository.fetchAll())
            System.out.println(record.toString());
        throw new RuntimeException(
            "printed out something but no clue what to do with that");
    }
}