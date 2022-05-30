package com.bl.serviceimplementation;

import com.bl.util.SingleConnection;
import com.bl.model.Student;
import com.bl.service.DatabaseAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessClass implements DatabaseAccess {
    static Connection con = SingleConnection.getInstance();
    List<Student> stulist = new ArrayList<>();



    @Override
    public int add(Student student) throws SQLException {
        String query
                = "insert into student(stu_name, "
                + "stu_address) VALUES (?, ?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, student.getStu_name());
        ps.setString(2, student.getStu_address());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query
                = "delete from student where stu_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public Student getStudent(int id) throws SQLException {
        String query
                = "select * from student where stu_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setInt(1, id);
        Student emp = new Student();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            emp.setStu_id(rs.getInt("stu_id"));
            emp.setStu_name(rs.getString("stu_name"));
            emp.setStu_address(rs.getString("stu_address"));
        }

        if (check == true) {
            return emp;
        } else
            return null;
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        String query = "select * from student";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Student> ls = new ArrayList();

        while (rs.next()) {
            Student stu = new Student();
            stu.setStu_id(rs.getInt("stu_id"));
            stu.setStu_name(rs.getString("stu_name"));
            stu.setStu_address(rs.getString("stu_address"));
            ls.add(stu);
        }
        return ls;
    }

    @Override
    public void update(Student student) throws SQLException {
        String query
                = "update student set stu_name=?, "
                + " stu_address= ? where stu_id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, student.getStu_name());
        ps.setString(2, student.getStu_address());
        ps.setInt(3, student.getStu_id());
        ps.executeUpdate();
    }

}

