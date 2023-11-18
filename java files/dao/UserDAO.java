package com.example.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.example.util.HibernateUtil;
import com.example.model.User;
public class UserDAO
{
	
	public int addUser(User user)
	{
		Session session = HibernateUtil.dbConn();
		Transaction transaction = session.beginTransaction();
		int value = (Integer) session.save(user);
		transaction.commit();
		session.close();
		return value;	
	}
}

