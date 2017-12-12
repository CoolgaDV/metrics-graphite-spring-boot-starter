package cdv.spring.starter.metrics.graphite.sample;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Dmitry Kulga
 *         12.12.2017 13:27
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        new SpringApplicationBuilder(ApplicationConfiguration.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
