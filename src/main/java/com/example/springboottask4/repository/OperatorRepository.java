package com.example.springboottask4.repository;

import com.example.springboottask4.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OperatorRepository extends JpaRepository<Operator, Long> {
    @Query("SELECT c FROM Operator c ORDER BY c.name")
    List<Operator> findAllSortByName();
}