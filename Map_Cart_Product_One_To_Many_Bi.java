package org.jsp.one_to_many_bi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one_to_many_bi.entityclasses.Cart;
import org.jsp.one_to_many_bi.entityclasses.Product;

public class Map_Cart_Product_One_To_Many_Bi {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		//finding products
		Product p1 = em.find(Product.class, 1);
//		Product p2 = em.find(Product.class, 8);
		//finding carts
		Cart c1 = em.find(Cart.class, 1);
		//setting carts to products
		p1.setC(c1);
//		p2.setC(c1);
		
		//getting products from cart
		List<Product> pl = c1.getProduct();
		//add to products
		pl.add(p1);
//		pl.add(p2);
		
		//set products to cart
		c1.setProduct(pl);
		
		et.begin();
		em.merge(p1);
//		em.merge(p2);
		em.merge(c1);
		et.commit();
		
	}
}