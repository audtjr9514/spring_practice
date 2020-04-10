package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dao.StudentDao;
import net.skhu.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired StudentDao studentDao;
	
	@Override
	public List<StudentDto> findAll(){
		return studentDao.findAll();
	}
}
