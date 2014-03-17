package project.g.core.main.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import project.g.core.data.BaseObject;

@Document
public class Navbar extends BaseObject {
	private String label;

	private String uri;

	private List<Navbar> childs;

	public Navbar() {
	}

	public Navbar(String label, String uri, List<Navbar> childs) {
		super();
		this.label = label;
		this.uri = uri;
		this.childs = childs;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Navbar> getChilds() {
		return childs;
	}

	public void setChilds(List<Navbar> childs) {
		this.childs = childs;
	}

}
