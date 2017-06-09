package com.dao.impls;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.IStudentDao;
import com.pojo.Student;

@Repository(value="studentDao")
public class StudentDaoImpl implements IStudentDao {
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	@Override
	public void add(Student s) {
		try {
			Session session = 
					sessionFactory.getCurrentSession();
			System.out.println(session);
			session.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
