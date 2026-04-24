package com.todoproject.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoproject.todo_api.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
