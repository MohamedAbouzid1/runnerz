package dev.mohamed.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import org.springframework.util.Assert;

@Repository
public class JdbcClientRunRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM run")
                .query(Run.class)
                .list();
    }
    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM run WHERE id = ?")
                .param(id)
                .query(Run.class)
                .optional();
    }
    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO run (id, title, started_on, completed_on, miles, location) values (?, ?, ?, ?, ?, ?)")
                .param(1, run.id())
                .param(2, run.title())
                .param(3, run.startedOn())
                .param(4, run.completedOn())
                .param(5, run.miles())
                .param(6, run.location().toString())
                .update();
        Assert.state(updated == 1, "Failed to insert run" + run.title());
    }
    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("UPDATE run SET title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?")
                .param(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
                .update();
        Assert.state(updated == 1, "Failed to update run" + run.title());
    }
    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM run WHERE id = ?")
                .param(id)
                .update();
        Assert.state(updated == 1, "Failed to delete run with id" + id);
    }
    public int count() {
        return jdbcClient.sql("SELECT * FROM run")
                .query()
                .listOfRows()
                .size();
    }
    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }
    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("SELECT * FROM run WHERE location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }
}
