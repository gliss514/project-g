package project.g.res.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.g.core.data.ProjGMongoTemplate;

@Service
public class MenuService {

	@Autowired
	private ProjGMongoTemplate mongoTemplate;

}
