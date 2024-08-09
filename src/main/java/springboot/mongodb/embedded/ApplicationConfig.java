package springboot.mongodb.embedded;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import springboot.mongodb.embedded.repository.MongoOrderRepository;

/**
 * Main config
 */
public class ApplicationConfig {
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    public MongoOrderRepository mongoOderRepository(MongoTemplate mongoTemplate) {
        return new MongoOrderRepository(mongoTemplate);
    }


}
