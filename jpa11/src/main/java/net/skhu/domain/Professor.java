package net.skhu.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@ToString(exclude={"department", "courses"})
@EqualsAndHashCode(exclude= {"department","courses"})
@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "professorName")
	String name;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy="professor", fetch = FetchType.LAZY)
	List<Course> courses;
}
