package project.g.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.customer.model.Customer;
import project.g.customer.model.CustomerService;
import project.g.res.menu.model.Menu;

@RequestMapping(value = "/searchCustomer")
@Controller
public class SearchCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("customer") Customer customer, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/searchCustomer");
		modelView.addObject("results", customerService.findAll());
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("customer/searchCustomer");
		return modelView;
	}
}
