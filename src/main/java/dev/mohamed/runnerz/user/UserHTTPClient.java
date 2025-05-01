package dev.mohamed.runnerz.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserHTTPClient {
    // I want to get a list of users
    List<User> findAll();

    @GetExchange("/users/{id}")
    // I want to get a user
    User findById(@PathVariable Integer id);

}
