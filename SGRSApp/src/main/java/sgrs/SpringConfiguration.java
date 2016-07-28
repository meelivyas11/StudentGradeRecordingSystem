package sgrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sgrs.Domain.User;


@Configuration
@ComponentScan({"srgs"})

public class SpringConfiguration {
	
	@Bean
	public User user() {
		return new User();
	}
}
