package net.skhu.dao;

import java.util.List;

import net.skhu.dto.StudentDto;

public interface StudentDao {
	List<StudentDto> findAll();
}
