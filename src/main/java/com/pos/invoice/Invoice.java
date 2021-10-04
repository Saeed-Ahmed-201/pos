package com.pos.invoice;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pos.bank.Bank;
import com.pos.customer.Customer;
import com.pos.enums.InvoiceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {
	   
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   private String bankAccountNo;
	   private String paymentType;
	   
	   private double totalAmount;
	   private double amountTendered;

	   private LocalDate dateRecorded;
	   
	   @Enumerated(EnumType.STRING)
	   @Column(name = "invoice_status")
	   private InvoiceStatus invoiceStatus;
	   
	   @ManyToOne
	   @JoinColumn(name = "bank_id")
	   private Bank bankInfo;
	   
	   @ManyToOne
	   @JoinColumn(name = "customer_id")
	   private Customer customer;
	   
	 

}
