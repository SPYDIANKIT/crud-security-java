package com.example.demo.service;


import java.util.List;

import com.example.demo.model.*;

public interface TaskService {
	boolean addTaskToUser(Long userId, Task task);
	boolean updateTaskStatus(Long id, String status);
	List<Task> getAllTasks();
	List<Task> getTasksForUser(Long userId);
	Task getTaskById(Long id);
}

