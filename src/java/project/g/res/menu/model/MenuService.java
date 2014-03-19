package project.g.res.menu.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.g.core.data.ProjGRepository;
import project.g.core.data.ProjGService;

@Service
public class MenuService extends ProjGService<Menu> {

	@Autowired
	private ProjGRepository<Menu> projGRepository;

	public Map<String, String> getMenuCategory() {
		Map<String, String> menuDataSource = new HashMap<String, String>();
		menuDataSource.put(null, "------- Please Select -------");
		menuDataSource.put(MenuConstant.APPETIZER, "Appetizer");
		menuDataSource.put(MenuConstant.BEVERAGE, "Beverage");
		menuDataSource.put(MenuConstant.DESSERTS, "Desserts");
		menuDataSource.put(MenuConstant.MAIN, "Main");
		menuDataSource.put(MenuConstant.SIDES, "Sides");
		return menuDataSource;
	}

	public Map<String, String> getMenuImages() {
		Map<String, String> menuImages = new HashMap<String, String>();
		menuImages.put("projg/images/main/fusilli_definition_picture_167290.jpg", "1");
		menuImages.put("projg/images/main/food_picture_01_hd_pictures_167558.jpg", "2");
		menuImages.put("projg/images/main/food_picture_03_hd_pictures_167556.jpg", "3");
		return menuImages;
	}

	@Override
	protected ProjGRepository<Menu> getRepository() {
		return projGRepository;
	}

	public List<Menu> findByCodeLikeAndNameLikeAndCategoryLike(Menu criteria) {
		String code = StringUtils.isEmpty(criteria.getCode()) ? "" : criteria.getCode();
		String name = StringUtils.isEmpty(criteria.getName()) ? "" : criteria.getName();
		String category = StringUtils.isEmpty(criteria.getCategory()) ? "" : criteria.getCategory();
		return projGRepository.findByCodeLikeAndNameLikeAndCategoryLike(code, name, category);
	}
}
