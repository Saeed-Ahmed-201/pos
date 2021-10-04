package com.pos.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pos.product.Product;
import com.pos.supplier.PurchaseOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   private String firstName;
	   private String lastName;
	   
	   private String password;
	   
	   private String fullName;
	   
	   @Column(name = "contact", unique = true)
	   private String contact;
	   
	   @Column(name = "email", unique = true)
	   private String email;

	   @ManyToMany
	   @JoinTable(name ="user_designation", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "designation_id"))
	   private List<Designation> designations;
	   
	   @ManyToMany
	   @JoinTable(name = "user_account_type", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
	   private List<AccountType> accountTypes;
	   
	   @OneToMany(mappedBy = "user")
	   private List<Product> products;
	   
	   @OneToMany(mappedBy = "user")
	   private List<PurchaseOrder> purchaseOrders;

}
