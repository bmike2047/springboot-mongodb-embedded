package springboot.mongodb.embedded.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import springboot.mongodb.embedded.model.Order;

/**
 * Order repository.
 */
public class MongoOrderRepository implements OrderRepository {

    private final MongoTemplate mongoTemplate;

    public MongoOrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Here we provide our custom query implementation
     *
     * @param productId
     * @return Order
     */
    @Override
    public Order findByProductId(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoTemplate.findOne(query, Order.class);
    }
}
