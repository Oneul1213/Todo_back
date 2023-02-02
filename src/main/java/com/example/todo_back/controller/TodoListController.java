package com.example.todo_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_back.dto.TodoItemDto;
import com.example.todo_back.service.TodoListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
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

    @PostMapping(value="/todo-list/item/save")
    public String saveTodoItem(@RequestBody TodoItemDto todoItem) {
        todoListService.saveTodoItem(todoItem);
        return "Item saved";
    }

    @PostMapping(value="/todo-list/item/remove")
    public String removeTodoItem(@RequestBody TodoItemDto todoItem) {
        todoListService.deleteTodoItemById(todoItem.getId());
        return "Item removed";
    }

    @PostMapping(value="/todo-list/item/update")
    public String updateTodoItem(@RequestBody TodoItemDto todoItem) {
        todoListService.updateTodoItem(todoItem);
        return "Item updated";
    }

    @PostMapping(value="/todo-list/save")
    public List<TodoItemDto> saveTodoList(@RequestBody List<TodoItemDto> todoList) {
        todoListService.saveTodoList(todoList);
        return todoList;
    }
}
