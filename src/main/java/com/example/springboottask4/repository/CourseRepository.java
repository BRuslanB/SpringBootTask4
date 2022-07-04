package com.example.springboottask4.repository;

import com.example.springboottask4.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c ORDER BY c.name")
    List<Course> findAllSortByName();
}