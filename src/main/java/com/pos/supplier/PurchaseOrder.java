package com.pos.supplier;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pos.product.Product;
import com.pos.user.User;

@Entity
@Table(name = "purchase_product")
public class PurchaseOrder {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private float quantity;
	    
	    private double unitPrice;
	    
	    private double sub_total;
	    
	    private LocalDate orderDate;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	   
	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

}
