package org.example.service;

import org.example.dto.Course;
import org.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    @Autowired
    CourseRepository courseRepository;

    public void addCourse(Course course) {
        courses.add(course);
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.searchAllByIdIsGreaterThan(0);
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.getTopById(id);
        //return courses.stream().filter(course ->course.getId() == id).findFirst();
    }

    public boolean deleteCourse(int id) {
        courseRepository.deleteById(String.valueOf(id));
        return courses.removeIf(course-> course.getId() == id);
    }

    public boolean updateCourse(int id, Course course) {
        return getCourseById(id).map(existingCourse ->  {
            courses.remove(existingCourse);
            courses.add(course);
            return true;
        }).orElse(false);
    }
}
