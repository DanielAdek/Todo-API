package com.example.todo.TodoApi;

import java.util.List;
import java.util.UUID;
import java.util.Objects;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TodoService {
  
  private final TodoRepository todoRepository;

  // @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public CustomResponse<List<Todo>>getAllTodos() {
    List<Todo> todo = this.todoRepository.findAll();
    String message = todo.isEmpty() ? "No todos yet" : "Successfully found todos";
    CustomResponse<List<Todo>> response = new CustomResponse<List<Todo>>(true, 200, message, todo);
    return response;
  }

  public CustomResponse<Todo>addNewTodo(Todo todo) {
    Todo new_todo = this.todoRepository.save(todo);
    return new CustomResponse<Todo>(true, 201, "Todo Created Successfully", new_todo);
  }

  @Transactional
  public CustomResponse<Todo>updateTodo(UUID id, Todo todo) {
    Todo todoExist = this.todoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Todo not found"));

    String item = todo.getItem();
    Boolean completed = todo.getCompleted();

    if (item != null) {
      if (item.length() > 0 & !Objects.equals(item, todoExist.getItem())) todoExist.setItem(item);
    }

    if (completed != null) {
      todoExist.setCompleted(completed);
    }

    return new CustomResponse<Todo>(true, 200, "Todo modified", todoExist);
  }
  
  public CustomResponse<Todo>delTodo(UUID id) {
    boolean exist = this.todoRepository.existsById(id);

    if (!exist) {
      throw new IllegalStateException("Todo does not exist");
    }
    
    this.todoRepository.deleteById(id);

    return new CustomResponse<Todo>(true, 204, "Todo Deleted Successfully", null);
  }
}
