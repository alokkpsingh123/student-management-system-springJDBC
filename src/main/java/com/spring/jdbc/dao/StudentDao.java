package com.spring.jdbc.dao;

import com.spring.jdbc.model.Student;

import java.util.List;

public interface StudentDao {
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(int studentId);
    public Student getStudent(int studentId);
    public List<Student> getAllStudent();
}
