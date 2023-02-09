package com.example.courses.controller;

import com.example.courses.model.Course;
import com.example.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.findAllCourses();
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id){
        Optional<Course> optCourse = courseService.findCourse(id);

        if(optCourse.isPresent()){
            Course course = optCourse.get();
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course inCourse){
        try {
            Course course = courseService.createCourse(inCourse);
            return new ResponseEntity<Course>(course, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> editCourse(@PathVariable int id, @RequestBody Course inCourse){
        Optional<Course> optCourse = courseService.findCourse(id);

        if(optCourse.isPresent()){
//            update the object
            Course course = optCourse.get();
            course.setCode(inCourse.getCode());
            course.setDescription(inCourse.getDescription());
            course.setName(inCourse.getName());

            Course updatedCourse = courseService.editCourse(course);
            return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") int id){

        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
