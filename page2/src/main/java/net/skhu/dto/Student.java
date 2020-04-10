package net.skhu.dto;

import lombok.Data;

@Data
public class Student {
	int id;
	String name;
	String studentNo;
	Department department;
	int year;
}
