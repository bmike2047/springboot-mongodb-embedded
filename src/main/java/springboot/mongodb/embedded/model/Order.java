package springboot.mongodb.embedded.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * Data model for an Order
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private @Id String id;
    private String customer;
    private String productId;

}
