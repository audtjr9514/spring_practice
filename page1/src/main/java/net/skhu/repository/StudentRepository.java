package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Student;
import net.skhu.model.Pagination;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Page<Student> findAll(Pageable pageable);
	
	public default List<Student> findAll(Pagination pagination){
		Pageable pageable = PageRequest.of(pagination.getPg() -1, pagination.getSz(), new Sort(Sort.Direction.ASC, "studentNo"));
		Page<Student> page = findAll(pageable);
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}
}
