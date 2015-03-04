package project.g.customer;

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

@RequestMapping(value = "/createCustomer")
@Controller
public class CreateCustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("customer") Customer customer,
			HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/createCustomer");
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("customer") Customer customer,
			BindingResult result, HttpServletRequest req) {
		String page = "menu/createCustomer";
		if (!result.hasErrors()) {
			page = "redirect:searchCustomer.g";
			customerService.save(customer);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		return model;
	}
}