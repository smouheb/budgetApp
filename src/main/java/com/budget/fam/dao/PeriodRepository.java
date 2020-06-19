package com.budget.fam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.budget.fam.domain.Period;

public interface PeriodRepository extends CrudRepository<Period, Long> {

	List<Period> findAll();
	
	@Query(
			value = "SELECT  * "
				  + "FROM period p " 
				  + "INNER JOIN expense e ON e.period_id = p.id "
				  + "WHERE p.status = 'ACTIVE' " ,
		   nativeQuery = true
		   )
	List<Period> findByStatusActive();
}
