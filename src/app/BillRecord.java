package app;

public class BillRecord
{
    private String prename;
    private String surname;
    private String service;
    private double price;

    public BillRecord(
            String prename,
            String surname,
            String service,
            double price)
    {
        this.prename = prename;
        this.surname = surname;
        this.service = service;
        this.price = price;
    }

    public String getPrename() {
        return prename;
    }

    public String getSurname() {
        return surname;
    }

    public String getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }
}