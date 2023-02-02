package com.example.todo_back.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo_back.dto.TodoItemDto;

@Mapper
@Repository
public interface H2TodoListRepository extends TodoListRepository {
    @Override
    @Select("select id, text, is_done isDone from todolist")
    public List<TodoItemDto> selectAllItems();

    @Override
    @Transactional
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into todolist (text, is_done) values (#{todoItem.text}, #{todoItem.isDone})")
    void insertItem(@Param("todoItem")TodoItemDto todoItemDto);

    @Override
    @Transactional
    @Delete("delete from todolist where id=#{id}")
    void deleteItemById(@Param("id")Long id);

    @Override
    @Transactional
    @Update("update todolist set text=#{todoItem.text}, is_done=#{todoItem.isDone} where id=#{todoItem.id}")
    void updateItem(@Param("todoItem")TodoItemDto todoItemDto);
}
