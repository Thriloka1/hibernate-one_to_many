package org.jsp.one_to_many_bi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one_to_many_bi.entityclasses.Cart;
import org.jsp.one_to_many_bi.entityclasses.Product;

public class RemoveProductFromCart {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int cid=1,pid=1;
		
		Cart c = em.find(Cart.class, cid);
		Product p = em.find(Product.class, pid);
		
		List<Product> p1 = c.getProduct();
		ArrayList<Product> al=new ArrayList<Product>();
		for(Product p2:p1) {
			if(p2.getId()!=pid) {
				al.add(p2);
			}
		}
		
		c.setProduct(al);
		et.begin();
		em.merge(c);
		et.commit();
		em.close();
		System.out.println("Done!...");
	}
}
