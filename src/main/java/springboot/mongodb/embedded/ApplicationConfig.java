package springboot.mongodb.embedded;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import springboot.mongodb.embedded.repository.MongoOrderRepository;

/**
 * Main application configuration.
 */
public class ApplicationConfig {
    /**
     * Define a mongo template bean.
     *
     * @param mongoDbFactory mongo factory
     * @return MongoTemplate
     */
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

    /**
     * Define a mongo order repository bean.
     *
     * @param mongoTemplate mongo template
     * @return
     */
    @Bean
    public MongoOrderRepository mongoOderRepository(MongoTemplate mongoTemplate) {
        return new MongoOrderRepository(mongoTemplate);
    }


}
