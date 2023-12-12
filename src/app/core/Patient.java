package app.core;

// TODO: user inputs are not validated in any kind.
public class Patient
{
    private int id;
    private String prename;
    private String surname;
    private String street;
    private String city;
    private String zipCode;

    public Patient(
        int id,
        String prename,
        String surname,
        String street,
        String city,
        String zipCode)
    {
        this.id = id;
        this.prename = prename;
        this.surname = surname;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPrename()
    {
        return prename;
    }

    public void setPrename(String prename)
    {
        this.prename = prename;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format(
            "Patient"
                + "(id=%d, prename=%s, surname=%s, street=%s, city=%s, zipCode=%s)",
                this.getId(),
                this.getPrename(),
                this.getSurname(),
                this.getStreet(),
                this.getCity(),
                this.getZipCode());
    }
}