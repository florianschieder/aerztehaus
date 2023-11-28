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
	
	@Override
	public String toString()
	{
		return String.format(
			"%s %s (%s: %.2f€)",
			this.surname,
			this.prename,
			this.service,
			this.price);
	}
}