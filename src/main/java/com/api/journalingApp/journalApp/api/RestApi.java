package com.api.journalingApp.journalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestApi {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping("/data")
    public Map<String, Object> sendData(@RequestBody Map<String, Integer> request) {
        if (!request.containsKey("id")) {
            throw new IllegalArgumentException("Missing 'id' in request body");
        }

        int id = request.get("id");
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    @PostMapping("/insertActor")
    public Map<String, Object> insertActor(@RequestBody Map<String, String> request) {
        String firstName = request.get("first_name");
        String lastName = request.get("last_name");

        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Both 'first_name' and 'last_name' are required.");
        }

        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?) RETURNING actor_id";
        int actorId = jdbcTemplate.queryForObject(sql, Integer.class, firstName, lastName);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Actor inserted successfully");
        response.put("actor_id", actorId);
        return response;
    }
}
