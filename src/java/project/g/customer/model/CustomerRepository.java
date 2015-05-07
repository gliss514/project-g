package project.g.customer.model;

import org.springframework.stereotype.Repository;

import project.g.core.data.ProjGRepository;

@Repository
public interface CustomerRepository extends ProjGRepository<Customer>{
	
	Customer findByCode(String code);
	
}
