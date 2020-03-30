package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.mapper.RegisterMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired StudentMapper studentMapper;
	@Autowired RegisterMapper registerMapper;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Student> students = studentMapper.findAll();
		model.addAttribute("students", students);
		return "student/list";
	}
	
//	@RequestMapping("delete")
//	public String delete(Model model, @RequestParam("id") int id) {
//		studentMapper.delete(id);
//		return "redirect:list";
//	}
	
	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id") int id) {
		studentMapper.delete(id);
		deleteStudent(id);
		return "redirect:list";
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private void deleteStudent(int studentId) {
		registerMapper.deleteByStudentId(studentId);
		studentMapper.delete(studentId);
	}
}
