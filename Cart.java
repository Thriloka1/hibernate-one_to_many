package org.jsp.one_to_many_bi.entityclasses;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
@Cacheable
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String personname;
	
	@OneToMany(mappedBy="c")
	private List<Product> product;
}
