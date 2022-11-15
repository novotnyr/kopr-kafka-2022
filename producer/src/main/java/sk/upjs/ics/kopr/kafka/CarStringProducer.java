package sk.upjs.ics.kopr.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class CarStringProducer {
    private KafkaTemplate<String, String> kafka;

    public CarStringProducer(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    @Scheduled(fixedDelay = 2, timeUnit = SECONDS)
    public void publishCar() {
        this.kafka.send("car", "New car produced at " + Instant.now());
    }
}
