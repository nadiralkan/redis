package tr.com.nadir.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("tr.com.nadir.redis")
public class RedisApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(RedisApplication.class);
	  }
}
