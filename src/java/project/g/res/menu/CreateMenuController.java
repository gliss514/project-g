package project.g.res.menu;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.res.menu.model.Menu;
import project.g.res.menu.model.MenuService;

@RequestMapping(value = "/createMenu")
@Controller
public class CreateMenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/createMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());
		modelView.addObject("images", menuService.getMenuImageByCateg(menu.getCategory()));
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("menu") Menu menu, BindingResult result) {
		String page = "menu/createMenu";
		if (!result.hasErrors()) {
			page = "redirect:viewMenu.g";
			menuService.save(menu);
		} else {
			System.out.println(result.getAllErrors().get(0).getDefaultMessage());
		}
		ModelAndView model = new ModelAndView(page);
		model.addObject("menuCategory", menuService.getMenuCategory());
		model.addObject("images", menuService.getMenuImageByCateg(menu.getCategory()));
		return model;
	}
}
