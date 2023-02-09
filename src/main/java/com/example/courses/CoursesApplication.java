package com.example.courses;

import com.example.courses.model.Course;
import com.example.courses.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursesApplication {

    public static void main(String[] args) {

        SpringApplication.run(CoursesApplication.class, args);

    }

    @Bean
    CommandLineRunner loadData(CourseRepository courseRepository){
        return (args) -> {
//            Add some Courses
            Course course1 = new Course();
            course1.setCode("FOPCS");
            course1.setName("Fundamentals of Programming in C#");
            course1.setDescription("FOPCS desc");
            courseRepository.save(course1);

            Course course2 = new Course();
            course2.setCode("OOPCS");
            course2.setName("Object Oriented Programming");
            course2.setDescription("OOPCS desc");
            courseRepository.save(course2);



        };
    }

}
