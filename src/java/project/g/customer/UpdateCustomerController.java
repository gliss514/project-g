package project.g.customer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.core.data.WebConstant;
import project.g.customer.model.Customer;
import project.g.customer.model.CustomerService;

@RequestMapping(value = "/updateCustomer")
@Controller
public class UpdateCustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(HttpServletRequest req, @ModelAttribute("customer") Customer customer) {
		ModelAndView modelView = new ModelAndView("customer/updateCustomer");
		String id = (String) req.getParameter(WebConstant.OBJID);
		Customer prevCustomer = customerService.findOne(id);
		modelView.addObject(prevCustomer);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		String page = "customer/updateCustomer";
		if (!result.hasErrors()) {
			Customer prevCustomer = customerService.findOne(customer.getId());
			BeanUtils.copyProperties(customer, prevCustomer);
			page = "redirect:searchCustomer.g";
			customerService.save(customer);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		return model;
	}
}
