package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
	int pg = 1; // 현재 페이지
	int sz = 15; // 페이지 당 레코드 수
	int di = 0; // departmentId
	int recordCount; // 총 레코드 수(목록 하단에 페이지 번호를 계산하기 위해 전체 학생 레코드 수를 알아야함)

	public String getQueryString() {
		return String.format("pg=%d&sz=%d&di=%d", pg, sz, di);
	}
}
