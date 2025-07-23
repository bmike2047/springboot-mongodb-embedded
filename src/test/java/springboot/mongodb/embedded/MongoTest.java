package springboot.mongodb.embedded;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import springboot.mongodb.embedded.model.Order;
import springboot.mongodb.embedded.repository.MongoOrderRepository;

import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@DataMongoTest(properties = {"de.flapdoodle.mongodb.embedded.version=6.0.15",
        "spring.data.mongodb.port=28018"})
public class MongoTest {

    @Autowired
    public MongoOrderRepository repository;

    @Test
    void testFindByProductId() {
        assertThat(repository.findOrderByProductId("P3"))
                .extracting("customer")
                .isEqualTo("John3");

    }

    @BeforeEach
    void setup() {
        LongStream.range(1, 5).forEach(i -> {
            Order order = new Order(String.valueOf(i), "John" + i, "P" + i);
            repository.save(order);
        });
        log.info("MONGO DATA SETUP: COMPLETED");
    }

}
