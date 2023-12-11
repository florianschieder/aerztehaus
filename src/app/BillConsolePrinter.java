package app;

import database.Repository;


public class BillConsolePrinter
{
    private Repository<BillRecord> billRecordRepository;

    public BillConsolePrinter(Repository<BillRecord> billRecordRepository)
    {
        this.billRecordRepository = billRecordRepository;
    }

    public void print()
    {
        for (BillRecord bill : this.billRecordRepository.fetchAll())
            System.out.println(
                String.format("%s\t%s\t%.2f\t%s",
                    bill.getSurname(),
                    bill.getPrename(),
                    bill.getPrice(),
                    bill.getService()));
    }
}