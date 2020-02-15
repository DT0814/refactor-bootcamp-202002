package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<Item> items;

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
