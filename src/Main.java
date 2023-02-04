import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        LocalDateTime date = LocalDateTime.now();

        System.out.println("Enter client data:");
        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("Birth date: ");
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birth = LocalDate.parse(sc.next(), fmt1);
        Client client = new Client(name, email, birth);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("How many items to this order? ");
        int orderNumbers = sc.nextInt();

        Order order = new Order(date, OrderStatus.valueOf(status), client);

        for(int i = 1; i <= orderNumbers; i++){
            sc.nextLine();
            System.out.printf("Enter #%d item data: %n", i);
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, price);
            OrderItem item = new OrderItem(quantity, price, product);
            order.addItem(item);
        }

        System.out.println();
        System.out.print(order);

    }
}