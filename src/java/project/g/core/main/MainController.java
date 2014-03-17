package project.g.core.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.core.main.model.Navbar;

@Controller
public class MainController {

	@Autowired
	NavbarService navbarService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("navbar") Navbar navbar, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("main/index");
		List<Navbar> results = navbarService.getResItems();
		modelView.addObject("navbarItems", results);
		return modelView;
	}

	@RequestMapping(value = "/main")
	public String mainpage() {
		return "main/main";
	}
}
