package com.example.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/runs")
@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    private List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    private Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);

        if (run.isPresent()) {
            return run.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
