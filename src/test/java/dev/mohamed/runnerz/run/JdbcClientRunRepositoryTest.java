package dev.mohamed.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
@JdbcTest
class JdbcClientRunRepositoryTest {
    @Autowired
    JdbcClientRunRepository jdbcClientRunRepository;

    @BeforeEach
    void setUp() {
        jdbcClientRunRepository.create(
                new Run(
                        1,
                        "Test Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                        5,
                        Location.INDOOR,
                        null));
        jdbcClientRunRepository.create(
                new Run(
                        2,
                        "Test Run2",
                        LocalDateTime.now(),
                        LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                        5,
                        Location.INDOOR,
                        null));

    }

}