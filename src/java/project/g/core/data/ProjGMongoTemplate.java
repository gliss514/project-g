package project.g.core.data;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

public class ProjGMongoTemplate extends MongoTemplate {
	public ProjGMongoTemplate(Mongo mongo, String databaseName) {
		super(mongo, databaseName);
	}

	@Override
	public void save(Object objectToSave) {
		super.save(objectToSave);
	}

	public void save(Object objectToSave, Class<?> clz) {
		if (!(objectToSave instanceof BaseObject)) {
			super.save(objectToSave);
			return;
		}

		BaseObject objectToSaveBO = (BaseObject) objectToSave;

		Object oldObject = findOne(new Query(Criteria.where("id").is(objectToSaveBO.getId())), clz);
		if (oldObject != null) {
			BeanUtils.copyProperties(objectToSaveBO, oldObject, "id", "version", "createBy", "updateBy", "createDate",
					"updateDate", "serialVersionUID");
			if (((BaseObject) oldObject).getVersion() != objectToSaveBO.getVersion()) {
				throw new RuntimeException();
			}
			save(oldObject);
		}
	}
}
