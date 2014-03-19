package project.g.core.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import project.g.res.menu.model.Menu;

@Repository
public interface ProjGRepository<T> extends PagingAndSortingRepository<T, String> {
	List<Menu> findByCodeLikeAndNameLikeAndCategoryLike(String code, String name, String category);
}
