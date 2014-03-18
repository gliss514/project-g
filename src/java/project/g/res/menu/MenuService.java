package project.g.res.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import project.g.core.data.ProjGMongoTemplate;
import project.g.res.menu.model.Menu;
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

	public List<Menu> find(Menu menu) {
		return mongoTemplate.find(
				new Query(Criteria.where("name").is(menu.getName())
						.andOperator(Criteria.where("code").is(menu.getCode()))), Menu.class);
	}

	public List<Menu> findAll() {
		return mongoTemplate.findAll(Menu.class);
	}

	public List<Menu> findByCategory(String category) {
		return mongoTemplate.find(new Query(Criteria.where("category").is(category)), Menu.class);
	}

	public void insert(Menu object) {
		mongoTemplate.insert(object);
	}

	public void save(Menu object) {
		mongoTemplate.save(object, Menu.class);
	}

	public void delete(String id) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Menu.class);
	}
}
