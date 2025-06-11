package service;

import model.Item;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void deleteItem(String name) {
        Item item = findItem(name);
        if (item != null) {
            items.remove(item);
            System.out.println("Item deleted.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void updateItem(String name, int quantity, double price) {
        Item item = findItem(name);
        if (item != null) {
            item.setQuantity(quantity);
            item.setPrice(price);
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found.");
        }
    }
}
