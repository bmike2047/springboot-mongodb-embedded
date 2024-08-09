package springboot.mongodb.embedded;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import springboot.mongodb.embedded.model.Order;
import springboot.mongodb.embedded.repository.MongoOrderRepository;

import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(properties = {"de.flapdoodle.mongodb.embedded.version=6.0.15",
        "spring.data.mongodb.port=27017"})
@AutoConfigureDataMongo
@EnableAutoConfiguration
@DirtiesContext
public class MongoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoTest.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testFindByProductId() {
        MongoOrderRepository mongoOderRepository = new MongoOrderRepository(mongoTemplate);
        assertThat(mongoOderRepository.findByProductId("P3"))
                .extracting("customer")
                .isEqualTo("John3");

    }

    @BeforeEach
    void setup() {
        LongStream.range(1, 5).forEach(i -> {
            Order order = new Order(i, "John" + i, "P" + i);
            mongoTemplate.save(order, "orders");
        });
        LOGGER.info("MONGO DATA SETUP: COMPLETED");
    }

}
