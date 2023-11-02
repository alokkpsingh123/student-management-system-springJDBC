package com.spring.jdbc.dao;

import com.spring.jdbc.model.Student;
import com.spring.jdbc.util.RowMapperImple;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;


public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertStudent(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        return this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
    }

    @Override
    public int updateStudent(Student student) {
        String query = "update student set name = ?, city = ? where id = ?";
        return this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public int deleteStudent(int studentId) {
        String query = "delete from student where id = ?";
        return this.jdbcTemplate.update(query, studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id = ?";
        RowMapper<Student>  rowMapper = new RowMapperImple();
        return this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
    }

    @Override
    public List<Student> getAllStudent() {
       String query = "select * from student";
        RowMapper<Student>  rowMapper = new RowMapperImple();
       return this.jdbcTemplate.query(query, rowMapper);
    }
}
