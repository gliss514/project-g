package project.g.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.g.core.data.WebConstant;
import project.g.customer.model.CustomerService;

@RequestMapping(value = "/deleteCustomer")
@Controller
public class DeleteCustomerController {

	private static final String REDIRECT_SEARCH_PAGE = "redirect:searchCustomer.g";

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String post(HttpServletRequest req) {
		String menuId = req.getParameter(WebConstant.OBJID);
		if (menuId != null) {
			customerService.delete(menuId);
		}
		return REDIRECT_SEARCH_PAGE;
	}
	
}
