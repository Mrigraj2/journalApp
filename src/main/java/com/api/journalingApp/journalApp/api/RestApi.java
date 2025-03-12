package com.api.journalingApp.journalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
}
