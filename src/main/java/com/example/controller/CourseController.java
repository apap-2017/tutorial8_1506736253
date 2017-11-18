package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.service.CourseService;


@Controller
public class CourseController
{
    @Autowired
    CourseService courseDAO;

    @RequestMapping("/course/view/{id}")
    public String selectCourseById (Model model,
            @PathVariable(value = "id") String id)
    {
    	CourseModel course = courseDAO.selectCourseById(id);
    	model.addAttribute("course", course);
        return "view-course";
    }

    @RequestMapping("/course/viewall")
    public String selectAll(Model model) {
    	List<CourseModel> courses = courseDAO.selectAllCourse();
    	model.addAttribute("courses",courses);
    	return "view-all-course";
    }
}
