package com;

import org.hibernate.Session;

public class userDao {

	public void save(User us)
	{
		try(Session ses=hbutil.getSessionFactory().openSession()){
			ses.beginTransaction();
			
			ses.persist(us);
			
			ses.getTransaction().commit();
		}
	}
	
	public boolean check(String email,String password) {
		
		try (Session session=hbutil.getSessionFactory().openSession()){
	        try {
	            String hql = "FROM User WHERE email = :email AND password = :password";
//	            Query<User> query = session.createQuery(hql, User.class);
//	            query.setParameter("email", email);
//	            query.setParameter("password", password);
//	            
//	            User user = query.uniqueResult();
//	            return user != null;
	            
	            User user = session.createQuery(hql,User.class).setParameter("email", email)
	            		.setParameter("password", password).uniqueResult();
	            
	            return user != null;
	            
	        } finally {
	            session.close();
	        }
	        
	        
	        
		}	
		
	}
	
	
	
}
