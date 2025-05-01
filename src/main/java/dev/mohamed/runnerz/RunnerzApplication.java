package dev.mohamed.runnerz;

import java.util.logging.Logger;

import dev.mohamed.runnerz.user.UserHTTPClient;
import dev.mohamed.runnerz.user.UserRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = Logger.getLogger(RunnerzApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Runnerz Application started successfully.");
	}

	@Bean
	UserHTTPClient userHTTPClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHTTPClient.class);
	}
	/*
	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(
					1,
					"Morning Run",
					LocalDateTime.now(),
					LocalDateTime.now().plusHours(1),
					5,
					Location.OUTDOOR);
			runRepository.create(run);
		};

	}
	*/
}