package cdv.spring.starter.metrics.graphite;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.codahale.metrics.jvm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author Dmitry Kulga
 *         11.12.2017 19:25
 */
@Configuration
@EnableConfigurationProperties(GraphiteMetricsConfiguration.class)
public class GraphiteMetricsAutoConfiguration {

    @Autowired
    private GraphiteMetricsConfiguration properties;

    @Bean
    public MetricRegistry getMetricsRegistry() {
        MetricRegistry registry = new MetricRegistry();
        registry.register("jvm.attributes", new JvmAttributeGaugeSet());
        registry.register("jvm.classloader", new ClassLoadingGaugeSet());
        registry.register("jvm.descriptors", new FileDescriptorRatioGauge());
        registry.register("jvm.gc", new GarbageCollectorMetricSet());
        registry.register("jvm.memory", new MemoryUsageGaugeSet());
        registry.register("jvm.threads", new ThreadStatesGaugeSet());
        return registry;
    }

    @Bean
    public GraphiteReporter getGraphiteReporter() {
        return GraphiteReporter.forRegistry(getMetricsRegistry())
                .prefixedWith(properties.getMetricsPrefix())
                .convertRatesTo(TimeUnit.MILLISECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(new Graphite(new InetSocketAddress(
                        properties.getGraphiteHost(),
                        properties.getGraphitePort())));
    }

}
