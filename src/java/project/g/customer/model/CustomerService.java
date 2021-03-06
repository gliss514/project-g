package project.g.customer.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.g.core.data.ProjGRepository;
import project.g.core.data.ProjGService;

@Service
public class CustomerService extends ProjGService<Customer>{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findByCode(String code){
		return customerRepository.findByCode(code);
	}
	
	public Map<String, String> getCustomerList(){
		Map<String, String> customerMap = new HashMap<>();
		
		Iterable<Customer> customerIter = findAll();
		customerMap.put("", "-- Select Customer --");
		for(Customer cust : customerIter){
			customerMap.put(cust.getCode(), cust.getCompanyName());
		}
		return customerMap;
	}
	
	public Map<String, String> getTypeList(){
		Map<String, String> typeMap = new HashMap<>();
		
		typeMap.put("", "-- Select Type --");
		typeMap.put("Consumer", "Consumer");
		typeMap.put("SME", "SME");
		return typeMap;
	}

	@Override
	protected ProjGRepository<Customer> getRepository() {
		return customerRepository;
	}

}
