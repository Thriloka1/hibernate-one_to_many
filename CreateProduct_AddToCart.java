package org.jsp.one_to_many_bi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one_to_many_bi.entityclasses.Cart;
import org.jsp.one_to_many_bi.entityclasses.Product;

public class CreateProduct_AddToCart {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p=new Product();
		p.setName("ford");
		p.setPrice(123453);
		
		et.begin();
		em.persist(p);
		
		Cart c = em.find(Cart.class, 4);
		List<Product> p1 = c.getProduct();
		p1.add(p);
		em.merge(c);
		et.commit();
		em.close();
		System.out.println("creating and adding product into cart is done!....");
				
		
		
		
		
	}
}
