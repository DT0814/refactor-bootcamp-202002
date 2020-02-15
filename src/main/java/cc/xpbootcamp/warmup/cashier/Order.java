package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String name;
    String address;
    List<Item> items;

    public Order(String name, String address, List<Item> items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<Item> getLineItems() {
        return items;
    }
}
