package com.example.todo_back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_back.dto.TodoItemDto;
import com.example.todo_back.repository.TodoListRepository;

@Service
public class TodoListService {
    private TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoItemDto> loadAllTodoItems() {
        return todoListRepository.selectAllItems();
    }

    public void saveTodoItem(TodoItemDto todoItem) {
        todoListRepository.insertItem(todoItem);
    }

    public void deleteTodoItemById(Long id) {
        todoListRepository.deleteItemById(id);
    }

    public void updateTodoItem(TodoItemDto todoItem) {
        // System.out.println("TodoItem.isDone = " + todoItem.getIsDone());
        todoListRepository.updateItem(todoItem);
    }

    public void saveTodoList(List<TodoItemDto> todoList) {
        for (TodoItemDto item : todoList) {
            todoListRepository.insertItem(item);
        }
    }
}
