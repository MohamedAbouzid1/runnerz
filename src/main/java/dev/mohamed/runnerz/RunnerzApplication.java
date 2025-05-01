package dev.mohamed.runnerz;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = Logger.getLogger(RunnerzApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Runnerz Application started successfully.");
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