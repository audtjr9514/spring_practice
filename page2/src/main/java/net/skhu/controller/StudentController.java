package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired StudentMapper studentMapper;
	@Autowired DepartmentMapper departmentMapper;
	
	@RequestMapping("list")
	public String list(Pagination pagination, Model model) {
		List<Student> list = studentMapper.findAll(pagination);
		pagination.setRecordCount(studentMapper.count(pagination));
		model.addAttribute("list", list);
		return "student/list";
	}
	
	@RequestMapping("list2")
	public String list2(Pagination pagination, Model model) {
		List<Student> list = studentMapper.findAll(pagination);
		pagination.setRecordCount(studentMapper.count(pagination));
		model.addAttribute("list", list);
		model.addAttribute("departments", departmentMapper.findAll());
		return "student/list2";
	}

}
