package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;

	@PostMapping("/users/{userId}/tasks")
	public ResponseEntity<String> addTaskToUser(@PathVariable Long userId, @RequestBody Task task) {
		boolean added = taskService.addTaskToUser(userId, task);
		if (added) {
			return new ResponseEntity<>("Task added to user with ID " + userId, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User with ID " + userId + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/tasks/{taskId}/status")
	public ResponseEntity<String> updateTaskStatus(@PathVariable Long taskId, @RequestParam String status) {
		boolean updated = taskService.updateTaskStatus(taskId, status);
		if (updated) {
			return new ResponseEntity<>("Task status updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Task with ID " + taskId + " not found", HttpStatus.NOT_FOUND);
		}
	}

	

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
