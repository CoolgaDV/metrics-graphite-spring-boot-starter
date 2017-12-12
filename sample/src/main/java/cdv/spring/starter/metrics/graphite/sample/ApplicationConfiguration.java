package cdv.spring.starter.metrics.graphite.sample;

import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Dmitry Kulga
 *         12.12.2017 13:32
 */
@Configuration
@EnableScheduling
@EnableAutoConfiguration
public class ApplicationConfiguration {

    @Autowired
    private MetricRegistry metrics;

    @Bean
    public MetricsProvider getMetricsProvider() {
        return new MetricsProvider(metrics);
    }

}
