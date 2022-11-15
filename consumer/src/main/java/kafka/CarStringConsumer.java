package kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CarStringConsumer {
    public static final Logger logger = LoggerFactory.getLogger(CarStringConsumer.class);

    @KafkaListener(topics = "car", groupId = "${kafka.cg:default}")
    public void onCar(String car) {
        logger.info("Producer car notification: {}", car);
    }
}
