package com.pos.bank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	   boolean existsByBankTitle(String bankTitle);
	   
	   @Query("SELECT b FROM Bank b WHERE b.isActive = true")
	   Page<Bank> findAll(Pageable pageable);

}
