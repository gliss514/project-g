package project.g.res.menu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.g.core.data.ProjGMongoTemplate;
import project.g.res.menu.model.MenuConstant;

@Service
public class MenuService {

	@Autowired
	private ProjGMongoTemplate mongoTemplate;

	public Map<String, String> getMenuCategory() {
		Map<String, String> menuDataSource = new HashMap<String, String>();
		menuDataSource.put(MenuConstant.APPETIZER, "Appetizer");
		menuDataSource.put(MenuConstant.BEVERAGE, "Beverage");
		menuDataSource.put(MenuConstant.DESSERTS, "Desserts");
		menuDataSource.put(MenuConstant.MAIN, "Main");
		menuDataSource.put(MenuConstant.SIDES, "Sides");
		return menuDataSource;
	}
}
