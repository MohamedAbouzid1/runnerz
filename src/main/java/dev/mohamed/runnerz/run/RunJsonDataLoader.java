package dev.mohamed.runnerz.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class RunJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final JdbcClientRunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(JdbcClientRunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        // Load JSON data and populate the database
        // This is where you would implement the logic to read from a JSON file
        // and insert the data into the database.
        // For example, you could use a library like Jackson or Gson to parse the JSON.
        if (runRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                log.info("Reading {} runs from JSON data and saving it to a database", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());
            } catch (IOException e) {
                throw new RuntimeException("Failed to load JSON data", e);
            }
        } else {
            log.info("Not loading JSON data, as the collection contains data");

        }
    }
}
