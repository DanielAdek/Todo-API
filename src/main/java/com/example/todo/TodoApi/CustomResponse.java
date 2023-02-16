package com.example.todo.TodoApi;

public class CustomResponse<T> {
  private Boolean status = true;
  private Integer statusCode = 200;
  private String message = "Successful";
  private T data;

  public CustomResponse(Boolean status, Integer statusCode, String message, T data) {
    this.status = status;
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }

  public Boolean getStatus() {
    return this.status;
  }
  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Integer getStatusCode() {
    return this.statusCode;
  }
  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return this.message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }
  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
