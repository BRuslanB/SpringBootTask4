package com.example.springboottask4.controllers;

import com.example.springboottask4.entities.ApplicationRequest;
import com.example.springboottask4.entities.Course;
import com.example.springboottask4.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService applicationRequestService;

    @GetMapping(value = "/")
    public String indexPage(Model model){

        List<ApplicationRequest> applicationRequests = applicationRequestService.getAllAppRequests();
        model.addAttribute("applicationRequests", applicationRequests);

        List<Course> courses = applicationRequestService.getAllCourses();
        model.addAttribute("courses", courses);

        return "indexPage";
    }

    @GetMapping(value = "/showNewApplicationRequest")
    public String showNewApplicationRequest(Model model){

        List<ApplicationRequest> applicationRequests = applicationRequestService.getAllNewAppRequests();
        model.addAttribute("applicationRequests", applicationRequests);

        List<Course> courses = applicationRequestService.getAllCourses();
        model.addAttribute("courses", courses);

        return "indexPage";
    }

    @GetMapping(value = "/showDoneApplicationRequest")
    public String showDoneApplicationRequest(Model model){

        List<ApplicationRequest> applicationRequests = applicationRequestService.getAllDoneAppRequests();
        model.addAttribute("applicationRequests", applicationRequests);

        List<Course> courses = applicationRequestService.getAllCourses();
        model.addAttribute("courses", courses);

        return "indexPage";
    }

    @GetMapping(value = "/addApplicationRequest")
    public String addApplicationRequest(Model model){

        List<Course> courses = applicationRequestService.getAllCourses();
        model.addAttribute("courses", courses);

        return "addApplicationRequest";
    }

    @PostMapping(value = "/addApplicationRequest")
    public String addApplicationRequest(@RequestParam(name = "app_course_id") Long course_id,
                         @RequestParam(name = "app_user_name") String user_name,
                         @RequestParam(name = "app_commentary") String commentary,
                         @RequestParam(name = "app_phone") String phone,
                         @RequestParam(name = "app_handled") boolean is_handled){

        Course crs = applicationRequestService.getCourse(course_id);
        if (crs != null) {
            ApplicationRequest applicationRequest = new ApplicationRequest();
            applicationRequest.setUserName(user_name);
            applicationRequest.setCommentary(commentary);
            applicationRequest.setPhone(phone);
            applicationRequest.set_handled(is_handled);
            applicationRequest.setCourse(crs);
            applicationRequestService.addAppRequest(applicationRequest);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/detailsApplicationRequest/{id}")
    public String detailsApplicationRequest(@PathVariable(name="id") Long id, Model model){

        ApplicationRequest applicationRequest = applicationRequestService.getAppRequest(id);
        model.addAttribute("applicationRequest", applicationRequest);

        List<Course> courses = applicationRequestService.getAllCourses();
        model.addAttribute("courses", courses);

        return "detailsApplicationRequest";
    }

    @PostMapping(value = "/saveApplicationRequest")
    public String saveApplicationRequest(@RequestParam(name = "app_id") Long id,
                          @RequestParam(name = "app_handled") boolean is_handled){

        ApplicationRequest applicationRequest = applicationRequestService.getAppRequest(id);

        if (applicationRequest != null){

            if (!is_handled) {
                is_handled = true;
                applicationRequest.set_handled(is_handled);
                applicationRequestService.saveAppRequest(applicationRequest);
            }
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deleteApplicationRequest")
    public String deleteApplicationRequest(@RequestParam(name = "app_id") Long id){

        ApplicationRequest applicationRequest = applicationRequestService.getAppRequest(id);

        if (applicationRequest != null){
            applicationRequestService.deleteAppRequest(applicationRequest);
        }
        return "redirect:/";
    }
}