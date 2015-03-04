package project.g.core.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.core.main.model.Navbar;
import project.g.core.security.model.User;

@Controller
public class MainController {

	@Autowired
	NavbarService navbarService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("user") User user) {
		ModelAndView modelView = new ModelAndView("main/index");
		return modelView;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("main/main");
		System.out.println(user.getUsername());
		modelView.addObject("navbarItems", getNavbars());
		return modelView;
	}
	
	private List<Navbar> getNavbars(){
		return navbarService.getResItems();
	}
}
