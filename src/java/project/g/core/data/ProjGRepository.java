package project.g.core.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjGRepository<T> extends PagingAndSortingRepository<T, String> {
	
}
