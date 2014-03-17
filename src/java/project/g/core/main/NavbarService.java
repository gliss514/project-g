package project.g.core.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project.g.core.main.model.Navbar;

@Service
public class NavbarService {

	// Get Navbar Menu
	public List<Navbar> getResItems() {
		List<Navbar> contents = new ArrayList<Navbar>();

		// Menu
		contents.add(createNavbar("gres.navbar.menu", "menu.g", null));

		// Order
		List<Navbar> makeOrder = new ArrayList<Navbar>();
		makeOrder.add(createNavbar("gres.navbar.dine-in", "order.g", null));
		makeOrder.add(createNavbar("gres.navbar.order.online", "orderOnline.g", null));
		contents.add(createNavbar("gres.navbar.make.order", "#", makeOrder));

		// Admin
		List<Navbar> adminPanel = new ArrayList<Navbar>();
		adminPanel.add(createNavbar("gres.title.manage.menu", "createMenu.g", null));
		contents.add(createNavbar("gres.navbar.admin", "#", adminPanel));

		return contents;
	}

	private Navbar createNavbar(String label, String link, List<Navbar> childs) {
		return new Navbar(label, link, childs);
	}
}
