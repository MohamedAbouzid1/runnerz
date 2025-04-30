package dev.mohamed.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday run", LocalDateTime.now(), LocalDateTime.now(), 5, Location.INDOOR));
        runs.add(new Run(2, "Tuesday run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 10,
                Location.OUTDOOR));
        runs.add(new Run(3, "Wednesday run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(45), 15,
                Location.INDOOR));
    }

}
