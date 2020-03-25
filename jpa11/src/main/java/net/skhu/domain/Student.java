package net.skhu.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@ToString(exclude= {"department", "registrations"})
@EqualsAndHashCode(exclude = {"department", "registrations"})
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	
	@Column(name = "studentNumber")
	String studentNo;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	List<Registration> registrations;
}
