package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repo.TaskRepository;
import com.example.demo.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private UserRepository userRepository;
    

    @Override
    public boolean addTaskToUser(Long user, Task task) {
        Optional<User> userOptional = userRepository.findById(user);
        if (userOptional.isPresent()) {
            User user1 = userOptional.get();
            task.setUser(user1);
            taskRepository.save(task);
            return true;
        }
        return false;
    }
    @Override
    public boolean updateTaskStatus(Long id, String status) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(status);
            taskRepository.save(task);
            return true;
        }	
        return false;
    }
	
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
	@Override
	public List<Task> getTasksForUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}