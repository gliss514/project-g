package project.g.res.menu.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.g.core.data.ProjGRepository;

@Repository
public interface MenuRepository extends ProjGRepository<Menu> {
	List<Menu> findByCodeLikeAndNameLikeAndCategoryLike(String code, String name, String category);
}
