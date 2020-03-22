package com.cognizant.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.AppConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
      
      StudentDao sdl = (StudentDao) ctx.getBean("studao");
      Student stb = (Student) ctx.getBean("student");
      stb.setId(100);
      stb.setMarks(50);
      stb.setName("JP");
      
      sdl.insert(stb);
      
      stb.setId(101);
      stb.setMarks(60);
      stb.setName("PP");
      
      sdl.insert(stb);
      
      List<Student> list = sdl.getAll();
      
      for(Student s:list)
      {
    	  System.out.println(s);
      }
      
    }
}
