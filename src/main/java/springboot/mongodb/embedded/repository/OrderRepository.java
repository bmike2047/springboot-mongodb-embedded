package springboot.mongodb.embedded.repository;

import org.springframework.data.repository.Repository;
import springboot.mongodb.embedded.model.Order;

public interface OrderRepository extends Repository<Order, Long> {
    Order findByProductId(String store);
}
