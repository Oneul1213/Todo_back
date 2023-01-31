package com.example.todo_back.repository;

import java.util.List;

import com.example.todo_back.dto.TodoItemDto;

public interface TodoListRepository {
    List<TodoItemDto> selectAllItems();
    void insertItem(TodoItemDto todoItemDto);
}
