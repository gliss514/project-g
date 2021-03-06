package project.g.res.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.res.menu.model.Menu;
import project.g.res.menu.model.MenuConstant;
import project.g.res.menu.model.MenuService;

@RequestMapping(value = "/viewMenu")
@Controller
public class ViewMenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/viewMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());

		menu.setCategory(MenuConstant.MAIN);
		modelView.addObject("mainResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.APPETIZER);
		modelView.addObject("appResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.BEVERAGE);
		modelView.addObject("bevResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		menu.setCategory(MenuConstant.DESSERTS);
		modelView.addObject("desResult", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));

		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("menu") Menu menu, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("menu/viewMenu");
		modelView.addObject("menuCategory", menuService.getMenuCategory());
		modelView.addObject("results", menuService.findByCodeLikeAndNameLikeAndCategoryLike(menu));
		return modelView;
	}
}