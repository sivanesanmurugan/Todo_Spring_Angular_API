package com.codewithsiva.repository;

import com.codewithsiva.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo",new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insertTodo(Todo todo) {
        jdbcTemplate.update("insert into todo (name) values (?);",new Object[]{todo.getName()});
        return findAll();
    }

    public List<Todo> updateTodo(Todo todo) {
        jdbcTemplate.update("update todo set name=? where id=?;",new Object[]{todo.getName(),todo.getId()});
        return findAll();
    }

    public List<Todo> deleteTodo(int id) {
        jdbcTemplate.update("delete from todo where id=?;",new Object[]{id});
        return findAll();
    }
}
