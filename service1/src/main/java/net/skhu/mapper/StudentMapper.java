package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.StudentDto;

@Mapper
public interface StudentMapper {
	List<StudentDto> findAll();
}
