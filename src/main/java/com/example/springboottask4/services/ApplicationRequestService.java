package com.example.springboottask4.services;

import com.example.springboottask4.entities.ApplicationRequest;
import com.example.springboottask4.entities.Course;
import com.example.springboottask4.entities.Department;
import com.example.springboottask4.entities.Operator;

import java.util.List;

public interface ApplicationRequestService {

    ApplicationRequest addAppRequest(ApplicationRequest applicationRequest);
    List<ApplicationRequest> getAllAppRequests();
    List<ApplicationRequest> getAllNewAppRequests();
    List<ApplicationRequest> getAllDoneAppRequests();
    ApplicationRequest getAppRequest(Long id);
    void deleteAppRequest(ApplicationRequest applicationRequest);
    ApplicationRequest saveAppRequest (ApplicationRequest applicationRequest);

    List<Course> getAllCourses();
    Course addCourse(Course course);
    Course saveCourse(Course course);
    Course getCourse(Long id);

    List<Department> getAllDepartments();
    Department addDepartment(Department department);
    Department saveDepartment(Department department);
    Department getDepartment(Long id);

    List<Operator> getAllOperators();
    Operator addOperator(Operator operator);
    Operator saveOperator(Operator operator);
    Operator getOperator(Long id);
}