package com.pos.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import com.pos.exception.CustomException;

@RestController
public class BankService {
	
	   
	   @Autowired
	   private BankRepository bankRepository;
	
	   public boolean addBank(Bank bank) throws CustomException {		    
		      try {
			      if(bankRepository.existsByBankTitle(bank.getBankTitle())) {
			    	  return false;
			      }
			      bankRepository.save(bank);
			      return true;
  
		      }
		      catch(Exception ex) {
		    	  throw new CustomException("Bank could not be inserted");
		      }
	   }
	   
	   public List<Bank> deleteBankById(Long id) throws CustomException{	
		      try {		    	  
		    	  bankRepository.deleteById(id);
		    	  List<Bank> banks = bankRepository.findAll();
		    	  return banks;
		      }
		      catch(Exception ex) {
		    	  throw new CustomException("Could not deleted bank");
		      }
	   }
	   
	   public Bank updateBank(Long id, Bank bank) throws CustomException{
		      try {
		    	 if(bankRepository.existsById(id)) {
		    		 Bank updateBank = bankRepository.findById(id).get();
		    		 updateBank.setBankTitle(bank.getBankTitle());
		    		 updateBank.setActive(bank.isActive());
		    		 return bankRepository.save(updateBank);
		    	 }
		    	 return null;
		      }
		      catch(Exception ex) {
		    	   throw new CustomException("Bank not found");
		      }
                 
	   }
	   
	   public List<Bank> retrieveAllBanks(Pageable pageable) throws CustomException{
		      try {
		    	  return bankRepository.findAll(pageable).getContent();		    	  
		      }
		      catch(Exception ex) {
		    	  throw new CustomException("No bank found");
		      }
	   }
	   
	   
	   public Bank retriveBankById(Long id) throws CustomException{
		      try {
		    	  return bankRepository.findById(id).orElse(null);
		      }
		      catch(Exception ex) {
		    	  throw new CustomException("Bank not found");
		      }
	   }

}
