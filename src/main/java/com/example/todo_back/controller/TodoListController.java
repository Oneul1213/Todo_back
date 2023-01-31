package com.example.todo_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todo_back.dto.TodoItemDto;
import com.example.todo_back.service.TodoListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TodoListController {
    private TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping(value="/todo-list/item/all")
    @ResponseBody
    public List<TodoItemDto> loadAllTodoItems() {
        return todoListService.loadAllTodoItems();
    }

    @PostMapping(value="/todo-list/save")
    public List<TodoItemDto> saveTodoList(@RequestBody List<TodoItemDto> todoList) {
        todoListService.saveTodoList(todoList);
        return todoList;
    }
    
}
