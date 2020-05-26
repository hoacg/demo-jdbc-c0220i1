package com.codegym;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private Connection connection;

    public CourseManager(Connection connection) {
        this.connection = connection;
    }

    public List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM khoa_hoc";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                courses.add( new Course(id, name ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại");
        }

        return courses;
    }

    public boolean insertCourse(Course course) {
        String sql = "INSERT INTO khoa_hoc(name) VALUES (?)";
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, course.getName());
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
