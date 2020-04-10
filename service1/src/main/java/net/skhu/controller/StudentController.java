package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.StudentDto;
import net.skhu.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired StudentService studentService;
	
	@RequestMapping("list")
	public List<StudentDto> list(){
		return studentService.findAll();
	}
}
