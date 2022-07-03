package com.example.springboottask4.services.imp;

import com.example.springboottask4.entities.ApplicationRequest;
import com.example.springboottask4.entities.Course;
import com.example.springboottask4.repository.ApplicationRequestRepository;
import com.example.springboottask4.repository.CourseRepository;
import com.example.springboottask4.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppReqServiceImpl implements ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ApplicationRequest addAppRequest(ApplicationRequest applicationRequest) {
        return applicationRequestRepository.save(applicationRequest);
    }

    @Override
    public List<ApplicationRequest> getAllAppRequests() {
        return applicationRequestRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getAllNewAppRequests() {
        return applicationRequestRepository.findAllStatusApplicationRequest(false);
    }

    @Override
    public List<ApplicationRequest> getAllDoneAppRequests() {
        return applicationRequestRepository.findAllStatusApplicationRequest(true);
    }

    @Override
    public ApplicationRequest getAppRequest(Long id) {
        return applicationRequestRepository.getReferenceById(id);
    }

    @Override
    public void deleteAppRequest(ApplicationRequest applicationRequest) {
        applicationRequestRepository.delete(applicationRequest);
    }

    @Override
    public ApplicationRequest saveAppRequest(ApplicationRequest applicationRequest) {
        return applicationRequestRepository.save(applicationRequest);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.getReferenceById(id);
    }
}