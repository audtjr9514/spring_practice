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
	@Autowired CourseMapper CourseMapper;

	@RequestMapping("list")
	public String list(Model model) {
		List<Course> courses = CourseMapper.findAll();
		model.addAttribute("courses", courses);
		return "course/list";
	}
}