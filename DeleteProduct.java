package org.jsp.one_to_many_bi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one_to_many_bi.entityclasses.Cart;
import org.jsp.one_to_many_bi.entityclasses.Product;

public class DeleteProduct {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p = em.find(Product.class, 2);
		Query q = em.createQuery("from Cart");
		List<Cart> cl = q.getResultList();
		
		for(Cart c:cl) {
			List<Product> p1 = c.getProduct();
			ArrayList al=new ArrayList();
			for(Product p2:p1) {
				if(p2.getId()!=p.getId()) {
					al.add(p2);
				}
			}
			c.setProduct(al);
			et.begin();
			em.merge(c);
			et.commit();
		}
		et.begin();
		em.remove(p);
		et.commit();
		em.close();
		System.out.println("deletion done");
	}
}
