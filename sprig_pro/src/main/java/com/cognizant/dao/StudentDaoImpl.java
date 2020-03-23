package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cognizant.model.Student;

@Component
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public String insert(Student s) {
		
		String sql = "Insert into Student values(?,?,?)";
		int r = jdbcTemplate.update(sql,s.getId(),s.getName(),s.getMarks());
	
		if(r>0)
		{
			return "Success";
		}
		return "Fail";
	}

	public List<Student> getAll() {
		
		String sql = "Select * from Student";
		
		RowMapper<Student> rowmap = new RowMapper<Student>() {
			
			public Student mapRow(ResultSet rs, int rw) throws SQLException
			{
				Student st = new Student();
				st.setId(rs.getInt("ID"));
				st.setName(rs.getString("Name"));
				st.setMarks(rs.getInt("Marks"));
				
				return st;
			}
		};
		
		List<Student> stu = jdbcTemplate.query(sql,rowmap);
		return stu;
		
	}

}
