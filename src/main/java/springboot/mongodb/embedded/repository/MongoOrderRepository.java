package springboot.mongodb.embedded.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springboot.mongodb.embedded.model.Order;

/**
 * Order repository.
 */
public interface MongoOrderRepository extends MongoRepository<Order, String> {

    /**
     * Custom query by productId.
     *
     * @param productId product id
     * @return Order
     */
    @Query("{ 'productId' : ?0 }")
    public Order findOrderByProductId(String productId);

}
