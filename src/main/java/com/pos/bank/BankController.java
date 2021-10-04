package com.pos.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.exception.CustomException;
import com.pos.response.Response;

@RestController
@RequestMapping(value = "/bank")
public class BankController {
	
	   @Autowired
	   private BankService bankService;
	   
	   @PostMapping(value = "/add-bank")
	   public ResponseEntity<Response<String>> addBank(@RequestBody Bank bank) throws CustomException{
		      if(bankService.addBank(bank)) {
		    	 return ResponseEntity.status(HttpStatus.CREATED).body(new Response<String>("Successully bank added", HttpStatus.CREATED));
		      }
		      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new Response<String>("Bank already exists", HttpStatus.UNPROCESSABLE_ENTITY));
	   }
	   
	   @DeleteMapping(value = "/delete-bank/{id}")
	   public ResponseEntity<Response<List<Bank>>> deleteBankById(@PathVariable Long id) throws CustomException{
		      List<Bank> banks = bankService.deleteBankById(id);
              return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response<List<Bank>>(banks, HttpStatus.ACCEPTED));		      
	   }

	   @PutMapping(value = "update-bank/{id}")
	   public ResponseEntity<Response<?>> updateBank(@PathVariable(name = "id") Long id, @RequestBody Bank updateBank) throws CustomException{
		           Bank bank =  bankService.updateBank(id, updateBank);
		         if(bank != null) {
		        	 return ResponseEntity.status(HttpStatus.OK).body(new Response<Bank>(bank, HttpStatus.OK));
		         }
		         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<String>("Bank not found", HttpStatus.NOT_FOUND));
	   }
	   
	   @GetMapping(value = "all-banks")
	   public ResponseEntity<Response<?>> retrieveAllBanks(@RequestParam(name = "page", defaultValue = "0") int page , @RequestParam(name = "size", defaultValue = "2") int size) throws CustomException{
		      Pageable paginator = PageRequest.of(page, size, Sort.by("bankTitle").ascending	());
		      List<Bank> banks = bankService.retrieveAllBanks(paginator);
		      if(!banks.isEmpty()) {
		    	  return ResponseEntity.status(HttpStatus.FOUND).body(new Response<List<Bank>>(banks, HttpStatus.FOUND));
		      }
		      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<String>("Banks not found", HttpStatus.NOT_FOUND));
	   }
	   
	   @GetMapping(value = "/{id}")
	   public ResponseEntity<Response<?>> retrieveBankById(@PathVariable("id") Long id) throws CustomException{
		       Bank bank = bankService.retriveBankById(id);
		       if(bank != null) {
		    	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response<Bank>(bank, HttpStatus.ACCEPTED));
		       }
		       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<String>("Bank not found", HttpStatus.NOT_FOUND));
	   }
}
