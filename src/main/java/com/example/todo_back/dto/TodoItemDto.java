package com.example.todo_back.dto;

import lombok.Data;

@Data
public class TodoItemDto {
    private Long id;
    private String text;
    private boolean isDone;
}
