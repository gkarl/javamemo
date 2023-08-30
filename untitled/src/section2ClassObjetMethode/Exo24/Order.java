package section2ClassObjetMethode.Exo24;

import java.util.List;

public class Order {

    private Long orderId;

    private List<Product> productListOrder;

    private Customer customer;

    public Order(List<Product> productListOrder, Customer customer) {
        this.productListOrder = productListOrder;
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductListOrder() {
        return productListOrder;
    }

    public void setProductListOrder(List<Product> productListOrder) {
        this.productListOrder = productListOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productListOrder=" + productListOrder +
                ", customer=" + customer +
                '}';
    }
}
