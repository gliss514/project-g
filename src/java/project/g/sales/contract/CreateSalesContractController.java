package project.g.sales.contract;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.customer.model.Customer;
import project.g.customer.model.CustomerService;
import project.g.sales.contract.model.SalesContract;
import project.g.sales.contract.model.SalesContractService;

@RequestMapping(value = "/createSalesContract")
@Controller
public class CreateSalesContractController {
	
	@Autowired
	private SalesContractService salesContractService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("salesContract") SalesContract salesContract,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("contract/createSalesContract");
		initDropdowns(modelView);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("salesContract") SalesContract salesContract,
			BindingResult result, HttpServletRequest req) {
		String page = "contract/createSalesContract";
		if (!result.hasErrors()) {
			page = "redirect:searchSalesContract.g";
			Customer customer = customerService.findByCode(salesContract.getCustomerCode());
			salesContract.setCustomer(customer);
			salesContractService.save(salesContract);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		initDropdowns(model);
		return model;
	}
	
	private void initDropdowns(ModelAndView model){
		model.addObject("customerList", customerService.getCustomerList());
	}

}
