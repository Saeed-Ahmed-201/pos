package com.pos.supplier;

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
@Table(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private String supplierCode;
	   
	   private String supplierName;
	   
	   private String supplierContact;
	   
	   private String supplierAddress;
	   
	   private String supplierEmail;
	   
	   private boolean supplierActive;
	   
	   @OneToMany(mappedBy = "supplier")
	   private List<RecieveProduct> recieveProducts;

}
