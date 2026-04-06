package com.dao;

import com.model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    private final Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Student student) throws SQLException {
        String sql = "INSERT INTO students(name) VALUES(?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.executeUpdate();
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name")));
            }
        }
        return list;
    }
}
