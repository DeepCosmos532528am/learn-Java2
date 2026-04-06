package com.sachin;


import com.dao.StudentDAO;
import com.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Load config values (from config.properties)
        String url = ConfigLoader.get("db.url");
        String user = ConfigLoader.get("db.user");
        String password = ConfigLoader.get("db.password");

        // Connect to DB
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected to DB");

            // Create DAO instance
            StudentDAO studentDAO = new StudentDAO(conn);

            // Ask user to insert a student
            System.out.print("Enter student name to insert: ");
            String name = sc.nextLine();

            // Insert student
            Student student = new Student(0, name); // id is auto-generated
            studentDAO.insert(student);
            System.out.println("✅ Student inserted.");

            // Fetch and print all students
            List<Student> students = studentDAO.getAll();
            System.out.println("\n📋 List of Students:");
            for (Student s : students) {
                System.out.println(s.getId() + " - " + s.getName());
            }

        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}


/*
// replaced by the dao verison above

import com.sachin.dao.StudentDAO;

import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
       System.out.println("JDBC setup--OK");
        Scanner sc = new Scanner(System.in);

       *//* String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "post@MuSiC20042214";
*//* // hardcoded values replaced by -->
        String url = ConfigLoader.get("db.url");
        String user = ConfigLoader.get("db.user");
        String password = ConfigLoader.get("db.password");



        try (Connection conn = DriverManager.getConnection(url, user, password)) {
           System.out.println("Connected to PostgreSQL successfully!");

            // 1) Create table
            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL)";
            Statement stmt = conn.createStatement();
           stmt.executeUpdate(createTable);
            System.out.println("Table created successfully (if not existed).");

            // 2) Insert a record
            String insertSQL = "INSERT INTO students(name) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(insertSQL);

            // Optional: Get name from user
            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();
            ps.setString(1, studentName);
            ps.executeUpdate();
            System.out.println("Inserted 1 row into students table.");

            // 3) Select and display students
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("Student in DB:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();


    }
}
*/





