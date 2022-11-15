package sk.upjs.ics.kopr.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class CarProducer {
    public static final Logger logger = LoggerFactory.getLogger(CarProducer.class);

    private final KafkaTemplate<String, Car> kafka;

    private final CarRandomizer carRandomizer = new CarRandomizer();

    public CarProducer(KafkaTemplate<String, Car> kafka) {
        this.kafka = kafka;
    }

    @Scheduled(fixedDelay = 2, timeUnit = SECONDS)
    public void publishCar() {
        var car = carRandomizer.randomCar();
        logger.info("Publishing car {}", car);
        this.kafka.send("supercar", car);
    }

}
