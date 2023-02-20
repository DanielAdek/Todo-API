package com.example.todo.TodoApi;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping()
  public CustomResponse<List<Todo>> getTodos() {
    return this.todoService.getAllTodos();
  }

  @PostMapping()
  public CustomResponse<Todo>createTodo(@RequestBody Todo todo) {
    return this.todoService.addNewTodo(todo);
  }

  @PutMapping("/{todoId}")
  public CustomResponse<Todo>editTodo(@PathVariable("todoId") UUID todoId, @RequestBody() Todo todo) {
    return this.todoService.updateTodo(todoId, todo);
  }

  @DeleteMapping(path = "{todoId}")
  public CustomResponse<?>removeTodo(@PathVariable("todoId") UUID todoId) {
    return this.todoService.delTodo(todoId);
  }
}
