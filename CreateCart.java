package org.jsp.one_to_many_bi.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one_to_many_bi.entityclasses.Cart;

public class CreateCart {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Cart c=new Cart();
		c.setPersonname("rj");
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
	}
}