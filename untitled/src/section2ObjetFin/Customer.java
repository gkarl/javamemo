package section2ObjetFin;

import java.time.LocalDate;
import java.util.List;

public class Customer {

    private Long customerId;
    private String FirstName;
    private String LastName;
    private LocalDate date;
    private Address address;

    private String phone;

    List<Order> order;

    public Customer(String firstName, String lastName, LocalDate date, Address address, String phone, List<Order> order) {
        FirstName = firstName;
        LastName = lastName;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.order = order;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", date=" + date +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", order=" + order +
                '}';
    }
}
