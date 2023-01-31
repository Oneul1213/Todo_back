package com.example.todo_back.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo_back.dto.TodoItemDto;

@Mapper
@Repository
public interface H2TodoListRepository extends TodoListRepository {
    @Override
    @Select("SELECT id, text, is_done FROM todolist")
    public List<TodoItemDto> selectAllItems();

    @Override
    @Transactional
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into todolist (text, is_done) values (#{todoItem.text}, #{todoItem.isDone})")
    void insertItem(@Param("todoItem")TodoItemDto todoItemDto);
}
