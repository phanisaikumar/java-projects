package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {/*
			Instructor tempInstructor = new Instructor("sai","narikalapa","kumar1.nps@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code");*/

			Instructor tempInstructor = new Instructor("hemarao","dunna","hemarao@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hemarao.com/youtube","hemarao code");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			System.out.println("saving instructor : "+tempInstructor);
			
			session.save(tempInstructor);
			
			
			session.getTransaction().commit();
			System.out.println("Done !!");
		}
		finally {
			factory.close();
		}

	}

}
