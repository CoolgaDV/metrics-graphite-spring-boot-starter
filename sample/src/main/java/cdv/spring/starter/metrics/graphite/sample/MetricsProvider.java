package cdv.spring.starter.metrics.graphite.sample;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Dmitry Kulga
 *         12.12.2017 13:34
 */
public class MetricsProvider {

    private final MetricRegistry metrics;
    private volatile int value = 0;

    public MetricsProvider(MetricRegistry metrics) {
        this.metrics = metrics;
    }

    @PostConstruct
    public void init() {
        metrics.register("gauge", (Gauge<Integer>) () -> value);
    }

    @Scheduled(fixedDelay = 5_000)
    public void refreshValue() {
        value = ThreadLocalRandom.current().nextInt(0, 100);
    }

}
