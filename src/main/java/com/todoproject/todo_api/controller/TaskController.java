package com.todoproject.todo_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoproject.todo_api.model.Task;
import com.todoproject.todo_api.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL TASKS
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // CREATE TASK
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {

        Task savedTask = taskService.createTask(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTask);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        Task updatedTask = taskService.updateTask(id, task);

        return ResponseEntity.ok(updatedTask);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }
}