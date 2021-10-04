package com.pos.invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pos.product.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sales {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private float quantity;
	   
	   private double price;
	   
	   private double sub_total;
	   
	   @ManyToOne
	   @JoinColumn(name = "invoice_id")
	   private Invoice invoice;
	   
	   @ManyToOne
	   @JoinColumn(name = "product_id")
	   private Product product;
	   	   
}
