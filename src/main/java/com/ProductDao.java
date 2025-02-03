package com;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProductDao {

	public void product_save(Products pd)
	{
		try(Session ses=hbutil.getSessionFactory().openSession()){
			ses.beginTransaction();
			
			ses.persist(pd);
			
			ses.getTransaction().commit();
		}
	}
	
	public List<Products> getAllProducts(){
		System.out.println("111");
		try(Session ses=hbutil.getSessionFactory().openSession()){
						
			List<Products> list=ses.createQuery("from Products", Products.class).getResultList();
		System.out.println("222");
			return list;
		}
	}
	
	public void delProductByName(String name) {
	    try (Session ses = hbutil.getSessionFactory().openSession()) {
	        ses.beginTransaction();

	        // Use HQL to find the product by name
	        Query query = ses.createQuery("DELETE FROM Products WHERE product_name = :pname");
	        query.setParameter("pname", name);

	        int result = query.executeUpdate(); // Execute the deletion
	        ses.getTransaction().commit();

	        if (result > 0) {
	            System.out.println("Product deleted successfully.");
	        } else {
	            System.out.println("No product found with name: " + name);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
