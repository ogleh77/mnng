package com.example.managementsystem.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Model {
    private static final Connection connection = DbConnection.getConnection();


    public void insert(Student student) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students(stname, grade) VALUES (?,?)");
            ps.setString(1, student.getName());
            ps.setDouble(2, student.getGrade());
            ps.executeUpdate();
            connection.commit();
            System.out.println("Inserted");
            ps.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    public ObservableList<Student> getStudents() throws SQLException {
        ObservableList<Student> students = FXCollections.observableArrayList();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            students.add(new Student(rs.getString(2), rs.getDouble(3)));
        }

        return students;
    }


}