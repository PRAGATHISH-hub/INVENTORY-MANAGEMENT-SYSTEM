package main;

import model.Item;
import service.InventoryService;
import java.util.Scanner;

public class InventoryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryService service = new InventoryService();

        while (true) {
            System.out.println("\n--- Inventory Management Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    service.addItem(new Item(name, quantity, price));
                    break;

                case 2:
                    service.displayItems();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    Item found = service.findItem(name);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();
                    service.updateItem(name, quantity, price);
                    break;

                case 5:
                    System.out.print("Enter name to delete: ");
                    name = scanner.nextLine();
                    service.deleteItem(name);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
