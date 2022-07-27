package com.ultron.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ultron.dto.OpenClass;
import com.ultron.dto.Registration;
import com.ultron.model.RegistrationModel;
import com.ultron.service.ConnectionManager;

public class RegistrationImpl implements RegistrationModel {

	@Override
	public List<Registration> findByClass(int id) {
		final String SELECT = """
				   SELECT rg.id,rg.student,rg.phone,rg.email,
				oc.id classId,oc.start_date,oc.teacher
				FROM registration rg JOIN open_class oc ON rg.open_class_id = oc.id WHERE oc.id=? ;
						 	                      """;
		List<Registration> data = new ArrayList<Registration>();

		try (var con = ConnectionManager.getConnection(); var stm = con.prepareStatement(SELECT)) {

			stm.setInt(1, id);
			var rs = stm.executeQuery();

			while (rs.next()) {
				OpenClass oc = new OpenClass();
				oc.setId(rs.getInt("id"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
				oc.setTeacher(rs.getString("teacher"));
				

				Registration rg = new Registration();
				rg.setOpenClass(oc);
				rg.setId(rs.getInt("id"));
				rg.setStudent(rs.getString("student"));
				rg.setPhone(rs.getString("phone"));
				rg.setEmail(rs.getString("email"));

				data.add(rg);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;

	}

	@Override
	public void save(Registration reg) {
		final String INSERT = "INSERT INTO registration(open_class_id,student,phone,email)VALUES(?,?,?,?)";

		try (var con = ConnectionManager.getConnection(); var stm = con.prepareStatement(INSERT)) {
			

			stm.setInt(1, reg.getOpenClass().getId());
			stm.setString(2, reg.getStudent());
			stm.setString(3, reg.getPhone());
			stm.setString(4, reg.getEmail());

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
