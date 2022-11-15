package kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sk.upjs.ics.kopr.kafka.Car;

@Component
public class CarConsumer {
    public static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);

    @KafkaListener(topics = "supercar", groupId = "${kafka.cg:default}")
    public void onCar(Car car) {
        logger.info("Supercar received: {}", car);
    }
}
