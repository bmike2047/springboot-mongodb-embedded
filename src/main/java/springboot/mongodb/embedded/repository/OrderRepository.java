package springboot.mongodb.embedded.repository;

import org.springframework.data.repository.Repository;
import springboot.mongodb.embedded.model.Order;

/**
 * Order repository domain type.
 */
public interface OrderRepository extends Repository<Order, Long> {
    /**
     * Find a product by id.
     *
     * @param productId product id
     * @return Order
     */
    Order findByProductId(String productId);
}
