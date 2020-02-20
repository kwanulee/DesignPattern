package hansung.designpatterns.iterator.dinermergercafe;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
	ArrayList<MenuItem> menus;


	public Waitress(ArrayList<MenuItem> menus) {
		this.menus = menus;
	}

	public void printMenu() {
		Iterator<?> menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = (Menu)menuIterator.next();
			printMenu(menu.createIterator());
			System.out.println();
		}
	}
 
	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n---------------");
		Iterator<?> menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = (Menu)menuIterator.next();
			printVegetarianMenu(menu.createIterator());
		}
	}

	public boolean isItemVegetarian(String name) {


		Iterator<?> menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = (Menu)menuIterator.next();
			Iterator<MenuItem> menuItemIterator = menu.createIterator();
			if (isVegetarian(name,menuItemIterator)) {
				return true;
			}
		}

		return false;
	}

	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName() + ", ");
				System.out.print(menuItem.getPrice() + " -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}

	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}

