package com.hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.config.HibernateConfig;
import com.hib.dto.User;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setName("Punya");
		session.saveOrUpdate(user);
		transaction.commit();
		User user1 = session.get(User.class, 5L);
		System.out.println(user1);
		session.close();
	}

}
