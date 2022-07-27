package com.ultron.model.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ultron.dto.Course;
import com.ultron.dto.OpenClass;
import com.ultron.model.OpenClassModel;
import com.ultron.service.ConnectionManager;

public class OpenClassImpl implements OpenClassModel {

	@Override
	public List<OpenClass> findByCourse(int id) {
		final String SELECT = """
				SELECT oc.id,oc.start_date,oc.teacher,
				c.id course_id,c.name,c.duration,c.fees,c.description
				           FROM open_class oc JOIN course c ON oc.course_id = c.id WHERE c.id = ?
				                 """;
		List<OpenClass> data = new ArrayList<OpenClass>();

		try (var connection = ConnectionManager.getConnection(); var stm = connection.prepareStatement(SELECT);) {

			stm.setInt(1, id);
			var rs = stm.executeQuery();

			while (rs.next()) {

				Course c = new Course();
				c.setId(rs.getInt("course_id"));
				c.setName(rs.getString("name"));
				c.setDuration(rs.getInt("duration"));
				c.setFees(rs.getDouble("fees"));
				c.setDescription(rs.getString("description"));

				OpenClass oc = new OpenClass();
				oc.setCourse(c);
				oc.setId(rs.getInt("id"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
				oc.setTeacher(rs.getString("teacher"));

				data.add(oc);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public void save(OpenClass openClass) {
		final String INSERT = "INSERT INTO open_class(course_id,start_date,teacher)VALUES(?,?,?)";

		try (var con = ConnectionManager.getConnection(); var stm = con.prepareStatement(INSERT)) {

			stm.setInt(1, openClass.getCourse().getId());
			stm.setDate(2, Date.valueOf(openClass.getStartDate()));
			stm.setString(3, openClass.getTeacher());

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public OpenClass findById(int id) {

		final String FIND_BY_ID = "SELECT id,start_date,teacher FROM open_class WHERE id = ?";

		try (var con = ConnectionManager.getConnection(); var stm = con.prepareStatement(FIND_BY_ID);) {

			stm.setInt(1, id);
			var rs = stm.executeQuery();

			while (rs.next()) {
				OpenClass oc = new OpenClass();
				oc.setId(rs.getInt("id"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
				oc.setTeacher(rs.getString("teacher"));
				return oc;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
