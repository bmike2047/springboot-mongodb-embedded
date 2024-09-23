package springboot.mongodb.embedded.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import springboot.mongodb.embedded.model.Order;

/**
 * Order repository.
 */
public class MongoOrderRepository implements OrderRepository {
    /**
     * Mongo template used for mongo operations
     */
    private final MongoTemplate mongoTemplate;

    /**
     * Default constructor for order repository.
     *
     * @param mongoTemplate mongo template
     */
    public MongoOrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Custom query implementation.
     *
     * @param productId product id
     * @return Order
     */
    @Override
    public Order findByProductId(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoTemplate.findOne(query, Order.class);
    }
}
