package com.pos.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pos.product.Product;

@Entity
@Table(name = "recieve_product")
public class RecieveProduct {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private float quantity;
	   
	   private double unitPrice;
	   
	   private double subTotal;
	   
	   @ManyToOne
	   @JoinColumn(name = "supplier_id")
	   private Supplier supplier;
	   
	   @ManyToOne
	   @JoinColumn(name = "product_id")
	   private Product product;

}
