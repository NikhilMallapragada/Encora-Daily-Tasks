package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperTask {
    private String assignedTo;
    private String taskName;
    private String deadline;
    private String status; // Not Started / In Process / Completed
}
