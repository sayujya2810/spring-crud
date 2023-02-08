package com.example.courses.service;

import com.example.courses.model.Course;
import com.example.courses.repository.CourseRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional (readOnly = true)
public class CourseServiceImpl implements CourseService{

    @Resource
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findCourse(int id) {
        return Optional.empty();
    }

    @Transactional (readOnly = false)
    @Override
    public Course createCourse(Course course) {
        return null;
    }

    @Transactional (readOnly = false)
    @Override
    public Course editCourse(Course course) {
        return null;
    }

    @Transactional (readOnly = false)
    @Override
    public void deleteCourse(int id) {

    }
}
