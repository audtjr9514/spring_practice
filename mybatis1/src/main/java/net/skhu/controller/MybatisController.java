package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.dto.User;
import net.skhu.mapper.CourseMapper;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.mapper.UserMapper;

@Controller
@RequestMapping("mybatis")
public class MybatisController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired UserMapper userMapper;
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

	@RequestMapping("dynamicSQL")
	public String dynamicSQL(Model model) {
		//전체 학생 목록 출력 : list1
		List<User> list1 = userMapper.findAllOrderBy(5,"name DESC");
		model.addAttribute("list1", list1);

		//id=2, name="이승진"

		//"이승진"이라는 이름으로 유저 검색 : list2
		User user1 = new User();
		user1.setName("이승진");
		List<User> list2 = userMapper.findByNameOrUserid(user1);
		model.addAttribute("list2", list2);

		//id=2인 사람의 name을 "Lee, Seungjin"으로 수정
		User user3 = new User();
		user3.setId(2);
		user3.setName("Lee, Seungjin");
		userMapper.update(user3);

		//"lsj"라는 아이디로 유저 검색 : list3
		User user2 = new User();
		user2.setUserid("lsj");
		List<User> list3 = userMapper.findByNameOrUserid2(user2);
		model.addAttribute("list3", list3); //lsj라는 userid를 가진 사람의 name은 Lee, Seungjin으로 출력

		//user3의 이름을 "Lee, Seungjin"에서 "이승진"으로 수정
		user3.setName("이승진");
		userMapper.update(user3);

		// 2,3,5의 id를 가진 학생 검색 = list4
		int[] a = new int[] {2,3,5};
		List<User> list4 = userMapper.findByIdList(a);
		model.addAttribute("list4", list4); //id=2인 user의 이름을 Lee,Seungjin에서 이승진으로 수정한 정보가 출력

		return "mybatis/dynamicSQL";
	}
}