package dev.mohamed.runnerz.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    // Custom query methods can be defined here if needed
    @Query
    List<Run> findAllByLocation(String location);
}
