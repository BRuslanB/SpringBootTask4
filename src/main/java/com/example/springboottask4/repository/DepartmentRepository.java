package com.example.springboottask4.repository;

import com.example.springboottask4.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT c FROM Department c ORDER BY c.name")
    List<Department> findAllSortByName();
}