package com.bl.service;

import com.bl.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccess {
    public int add(Student student)
            throws SQLException;

    public void delete(int id)
            throws SQLException;

    public Student getStudent(int id)
            throws SQLException;

    public List<Student> getStudents()
            throws SQLException;

    public void update(Student student)
            throws SQLException;

}

