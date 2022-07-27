package com.ultron.model;

import java.util.List;

import com.ultron.dto.Registration;

public interface RegistrationModel {

	List<Registration> findByClass(int id);

	void save(Registration rg);

	

}
