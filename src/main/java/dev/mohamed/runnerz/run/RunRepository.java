package dev.mohamed.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    // method to be able to create a new run
    void create(Run run) {
        runs.add(run);
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
