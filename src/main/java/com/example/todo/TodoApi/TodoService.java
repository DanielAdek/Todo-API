package com.example.todo.TodoApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  
  private final TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public CustomResponse<List<Todo>>getAllTodos() {
    List<Todo> todo = this.todoRepository.findAll();
    String message = todo.isEmpty() ? "No todos yet" : "Successfully found todos";
    CustomResponse<List<Todo>> response = new CustomResponse<List<Todo>>(true, 200, message, todo);
    return response;
  }
}
