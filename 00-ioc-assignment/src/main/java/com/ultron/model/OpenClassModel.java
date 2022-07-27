package com.ultron.model;

import java.util.List;

import com.ultron.dto.OpenClass;

public interface OpenClassModel {

	List<OpenClass> findByCourse(int id);

	void save(OpenClass openClass);
	
	OpenClass findById(int id);

}
