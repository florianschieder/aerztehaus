package app.core;

public class Patient
{
    private String id;
    private String prename;
    private String surname;
    private String street;
    private String city;
    private String zipCode;

    public Patient(
        String id,
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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
        return
            "Patient [id=" + id
            + ", prename=" + prename
            + ", surname=" + surname
            + ", street=" + street
            + ", city=" + city
            + ", zipCode=" + zipCode + "]";
    }
}