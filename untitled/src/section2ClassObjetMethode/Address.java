package section2ClassObjetMethode;

public class Address {

    private String Address;

    private String city;
    private String state;

    public Address(String address, String city, String state) {
        Address = address;
        this.city = city;
        this.state = state;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "section2ClassObjetMethode.Address{" +
                "section2ClassObjetMethode.Address='" + Address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
