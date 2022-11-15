package sk.upjs.ics.kopr.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class CarStringProducer {
    private KafkaTemplate<String, String> kafka;

    private AtomicInteger counter = new AtomicInteger();

    public CarStringProducer(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    @Scheduled(fixedDelay = 2, timeUnit = SECONDS)
    public void publishCar() {
        this.kafka.send("car", "New car #" + counter.getAndIncrement() + " produced at " + Instant.now());
    }
}
