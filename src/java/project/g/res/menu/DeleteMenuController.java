package project.g.res.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.g.core.data.WebConstant;
import project.g.res.menu.model.MenuService;

@RequestMapping(value = "/deleteMenu")
@Controller
public class DeleteMenuController {

	private static final String REDIRECT_SEARCH_PAGE = "redirect:viewMenu.g";

	@Autowired
	private MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public String post(HttpServletRequest req) {
		String menuId = req.getParameter(WebConstant.OBJID);
		if (menuId != null) {
			menuService.delete(menuId);
		}
		return REDIRECT_SEARCH_PAGE;
	}
}
