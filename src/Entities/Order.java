package Entities;

import Entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;

    private final List<OrderItem> item = new ArrayList<>();
    private Client client;

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItem(){
        return this.item;
    }

    public void addItem(OrderItem item){
        this.item.add(item);
    }

    public void removeItem(OrderItem item){
        this.item.remove(item);
    }

    public Double total(){
        Double sum = 0.0;
        for(OrderItem i: item){
            sum  += i.subTotal();
        }
        return sum;
    }

    public String toString(){
        DateTimeFormatter ftm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("ORDER SUMMARY \n");
        builder.append("Order moment: ");
        builder.append(moment.format(ftm1) + "\n");
        builder.append("Order status: ");
        builder.append(status + "\n");
        builder.append("Client: ");
        builder.append(client + "\n");
        builder.append("Order items: \n");
        for(OrderItem item: item){
            builder.append(item.getProduct().getName());
            builder.append(", $");
            builder.append(String.format("%.2f" , item.getPrice()));
            builder.append(", Quantity: ");
            builder.append(item.getQuantity());
            builder.append(", SubTotal: ");
            builder.append(String.format("%.2f" ,item.subTotal()) + "\n");
        }
        builder.append("Total price: $");
        builder.append(String.format("%.2f" ,total()));

        return builder.toString();
    }
}
