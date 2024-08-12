package org.jsp.one_to_many_bi.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one_to_many_bi.entityclasses.Product;

public class CreateProduct {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p=new Product();
		p.setName("hpp");
		p.setPrice(10000);
		
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
		
		
	}
}
