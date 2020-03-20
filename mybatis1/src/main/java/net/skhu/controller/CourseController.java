package net.skhu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Course;
import net.skhu.mapper.CourseMapper;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired CourseMapper courseMapper;

	@RequestMapping("courseList1")
	public String courseList(Model model) {
		List<Course> courses = courseMapper.findAllWithDepartments();
		model.addAttribute("courses", courses);
		return "course/courseList";
	}

	@RequestMapping("courseList2")
	public String courseList2(Model model) {
		List<Course> courses = courseMapper.findAllWithDepartmentsAndProfessors();
		model.addAttribute("courses", courses);
		return "course/courseList2";
	}

	@RequestMapping("courseList3")
	public String courseList3(Model model) {
		model.addAttribute("courses", courseMapper.findAllWithStudents());
		return "course/courseList3";
	}


}