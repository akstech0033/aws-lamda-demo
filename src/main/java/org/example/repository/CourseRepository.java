package org.example.repository;

import org.example.dto.Course;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableScan
public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> getAllById(int id);

    Optional<Course> getTopById(int id);

    List<Course> searchAllByIdIsGreaterThan(int idIsGreaterThan);
}