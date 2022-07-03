package com.example.springboottask4.repository;

import com.example.springboottask4.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
     @Query("SELECT c FROM ApplicationRequest c WHERE c.is_handled = :is_handled")
     List<ApplicationRequest> findAllStatusApplicationRequest(boolean is_handled);
}