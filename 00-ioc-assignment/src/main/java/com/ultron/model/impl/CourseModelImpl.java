package com.ultron.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ultron.dto.Course;
import com.ultron.model.CourseModel;
import com.ultron.service.ConnectionManager;

public class CourseModelImpl implements CourseModel {

	// Get Data Process
	@Override
	public List<Course> getAll() {

		final String SELECT = "SELECT * FROM course";
		var list = new ArrayList<Course>();
		try (var connection = ConnectionManager.getConnection(); var stm = connection.prepareStatement(SELECT)) {

			var result = stm.executeQuery();

			while (result.next()) {
				Course course = new Course();
				course.setId(result.getInt(1));
				course.setName(result.getString(2));
				course.setFees(result.getDouble(3));
				course.setDuration(result.getInt(4));
				course.setDescription(result.getString(5));

				// Add data
				list.add(course);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Save Process
	@Override
	public void save(Course course) {
		final String INSERT = "INSERT INTO course (name,fees,duration,description)VALUES(?,?,?,?)";

		try (var connection = ConnectionManager.getConnection(); var stm = connection.prepareStatement(INSERT)) {
			stm.setString(1, course.getName());
			stm.setDouble(2, course.getFees());
			stm.setInt(3, course.getDuration());
			stm.setString(4, course.getDescription());

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Course findById(int id) {
		final String BYID = "SELECT * FROM course WHERE id = ?";

		try (var connection = ConnectionManager.getConnection(); var stm = connection.prepareStatement(BYID)) {

			stm.setInt(1, id);
			var result = stm.executeQuery();

			while (result.next()) {
				Course course = new Course();
				course.setId(result.getInt(1));
				course.setName(result.getString(2));
				course.setFees(result.getDouble(3));
				course.setDuration(result.getInt(4));
				course.setDescription(result.getString(5));

				return course;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
