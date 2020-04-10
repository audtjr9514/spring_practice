package net.skhu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.skhu.dto.StudentDto;
import net.skhu.mapper.StudentMapper;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired StudentMapper studentMapper;
	
	@Override
	public List<StudentDto> findAll(){
		return studentMapper.findAll();
	}
}
