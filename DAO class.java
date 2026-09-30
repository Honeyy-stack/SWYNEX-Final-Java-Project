package com.swynex.studentapp.dao;

import com.swynex.studentapp.model.Student;
import com.swynex.studentapp.util.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students(name,email,phone,course,marks) VALUES(?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setDouble(5, s.getMarks());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phone"),
                        rs.getString("course"), rs.getDouble("marks")));
            }
        }
        return list;
    }

    public void updateStudent(int id, Student s) throws SQLException {
        String sql = "UPDATE students SET name=?, email=?, phone=?, course=?, marks=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setDouble(5, s.getMarks());
            ps.setInt(6, id);
            ps.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Student searchById(int id) throws SQLException {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM students WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phone"),
                        rs.getString("course"), rs.getDouble("marks"));
            }
        }
        return null;
    }
}
