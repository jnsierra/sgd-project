package co.com.ud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.com.ud")
@EnableJpaRepositories(basePackages={"co.com.ud.repo.repository"})
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
