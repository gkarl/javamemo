package section2ObjetFin;

public class Address {

    private String adresse1;

    private String city;

    private Long ZipCode;

    public Address() {
    }

    public Address(String adresse1, String city, Long zipCode) {
        this.adresse1 = adresse1;
        this.city = city;
        ZipCode = zipCode;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return ZipCode;
    }

    public void setZipCode(Long zipCode) {
        ZipCode = zipCode;
    }

    @Override
    public String toString() {
        return "section2ClassObjetMethode.Address{" +
                "adresse1='" + adresse1 + '\'' +
                ", city='" + city + '\'' +
                ", ZipCode=" + ZipCode +
                '}';
    }
}
