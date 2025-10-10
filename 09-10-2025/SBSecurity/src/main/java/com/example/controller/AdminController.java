package com.example.controller;

import com.example.model.DeveloperTask;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final List<DeveloperTask> tasks = new ArrayList<>();

    // Assign a new task
    @PostMapping("/assignTask")
    public String assignTask(@RequestBody DeveloperTask task) {
        task.setStatus("Not Started"); // default status
        tasks.add(task);
        return "Task assigned to " + task.getAssignedTo();
    }

    // Get all tasks
    @GetMapping("/tasks")
    public List<DeveloperTask> getTasks() {
        return tasks;
    }
}
