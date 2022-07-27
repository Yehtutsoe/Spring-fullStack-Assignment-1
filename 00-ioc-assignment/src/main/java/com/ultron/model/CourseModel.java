package com.ultron.model;

import java.util.List;

import com.ultron.dto.Course;

public interface CourseModel {

	List<Course> getAll();

	void save(Course course);

	Course findById(int id);

}
