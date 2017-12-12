package cdv.spring.starter.metrics.graphite;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmitry Kulga
 *         11.12.2017 19:25
 */
@Configuration
@EnableConfigurationProperties(GraphiteMetricsConfiguration.class)
public class GraphiteMetricsAutoConfiguration {



}
