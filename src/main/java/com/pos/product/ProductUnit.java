package com.pos.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUnit {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private String unitName;
	   
	   @OneToMany(mappedBy = "productUnit")
	   private List<Product> products;

}
