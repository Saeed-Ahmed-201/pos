package com.pos.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pos.supplier.PurchaseOrder;
import com.pos.supplier.RecieveProduct;
import com.pos.user.User;

@Entity
@Table(name = "product")
public class Product {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private String productCode;
	   private String barCode;
	   private String productName;
	   private float  unitInStock;
	   private double unitPrice;
	   private float  discountCharge;
	   private float  reorderLevel;
	   
	   @ManyToOne()
	   @JoinColumn(name = "user_id")
	   private User user;
	   
	   @ManyToOne
	   @JoinColumn(name = "product_unit_id")
	   private ProductUnit productUnit;
	   
	   @OneToMany(mappedBy = "product")
	   private List<PurchaseOrder> purchaseOrders;
	   
	   
	   @OneToMany(mappedBy = "product")
	   private List<RecieveProduct> recieveProducts;
	   
	   @ManyToOne
	   @JsonBackReference
	   private Category category;
	   

}
