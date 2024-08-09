package springboot.mongodb.embedded.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Data model for an Order
 */
@Document(collection = "orders")
public class Order {
    private final @Id Long id;
    private String customer;
    private String productId;

    public Order(Long id, String customer, String productId) {
        this.id = id;
        this.customer = customer;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
