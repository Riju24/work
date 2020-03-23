package com.cognizant;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.AppConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class AppTest {

	private AnnotationConfigApplicationContext cntx;
	private StudentDao st;
	private Student s;
	
	@Before
	public void setup()
	{
		cntx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		st = (StudentDao) cntx.getBean("studao");
		s = (Student) cntx.getBean("student");
	}
	
	@Test
	public void testInsert() {
		
		s.setId(124);
		s.setName("KP");
		s.setMarks(20);
		assertEquals("Success",st.insert(s));
	}
	
	@Test
	public void testGetAll() {
		List<Student> stud = st.getAll();
		assertEquals(2,stud.size());
	}

}
