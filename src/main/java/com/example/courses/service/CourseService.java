package com.example.courses.service;

import com.example.courses.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAllCourses();
    Optional<Course> findCourse(int id);
    Course createCourse(Course course);
    Course editCourse(Course course);
    void deleteCourse(int id);
}
