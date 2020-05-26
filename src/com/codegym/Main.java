package com.codegym;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance().getConnection();

        CourseManager courseManager = new CourseManager(connection);

        courseManager.insertCourse(new Course("C#"));
        courseManager.insertCourse(new Course("JavaScript"));

        List<Course> courses = courseManager.getCourseList();
        for (Course course: courses) {
            System.out.println(String.format("%s | %s", course.getId(), course.getName()));
        }
    }
}
