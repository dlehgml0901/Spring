package com.occamsrazor.web.grade;

import org.springframework.stereotype.Component;

import com.occamsrazor.web.util.Credit;

@Component
public interface GradeService {
	public void add(Grade grade);
	public int count();
	public Credit detail(String userid);
}
