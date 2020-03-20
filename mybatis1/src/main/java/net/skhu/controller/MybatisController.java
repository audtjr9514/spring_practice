package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.CourseMapper;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("mybatis")
public class MybatisController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired CourseMapper courseMapper;

	@RequestMapping(value = "cacheTest", method = RequestMethod.GET)
	public String cacheTest(Model model) {
		List<Department> departments = departmentMapper.findAll();
		model.addAttribute("departments", departments);
		model.addAttribute("department", departments.get(0));
		return "mybatis/cacheTest";
	}

	@RequestMapping(value = "cacheTest", method = RequestMethod.POST)
	public String cache(Model model, Department department) {
		departmentMapper.update(department);
		return "redirect:cacheTest";
	}

	@RequestMapping("departmentList1")
	public String departmentList1(Model model) {
		List<Department> departments = departmentMapper.findAll();
		for(Department department : departments) {
			List<Student> students = studentMapper.findByDepartmentId(department.getId());
			department.setStudents(students);
		}
		model.addAttribute("departments", departments);
		return "mybatis/departmentList";
	}

	@RequestMapping("departmentList2")
	public String departmentList2(Model model) {
		model.addAttribute("departments",departmentMapper.findAllWithStudents());
		return "mybatis/departmentList";
	}

}