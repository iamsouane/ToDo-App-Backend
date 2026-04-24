package com.todoproject.todo_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todoproject.todo_api.model.Task;
import com.todoproject.todo_api.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updateTask) {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setCompleted(updateTask.isCompleted());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
