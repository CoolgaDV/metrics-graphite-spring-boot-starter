package cdv.spring.starter.metrics.graphite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Dmitry Kulga
 *         12.12.2017 11:04
 */
@ConfigurationProperties(prefix = "metrics.graphite")
public class GraphiteMetricsProperties {

    @Value("${host:localhost}")
    private String graphiteHost;

    @Value("${port:2003}")
    private short graphitePort;

    @Value("${prefix:app}")
    private String metricsPrefix;

    public String getMetricsPrefix() {
        return metricsPrefix;
    }

    public void setMetricsPrefix(String metricsPrefix) {
        this.metricsPrefix = metricsPrefix;
    }

    public String getGraphiteHost() {
        return graphiteHost;
    }

    public void setGraphiteHost(String graphiteHost) {
        this.graphiteHost = graphiteHost;
    }

    public short getGraphitePort() {
        return graphitePort;
    }

    public void setGraphitePort(short graphitePort) {
        this.graphitePort = graphitePort;
    }

}
