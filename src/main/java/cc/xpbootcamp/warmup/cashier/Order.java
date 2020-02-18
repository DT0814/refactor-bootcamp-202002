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

    public double getTotal() {
        double total = 0d;
        for (Item lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            total += lineItem.totalAmount() + salesTax;
        }
        return total - getDiscount();
    }

    public double getTotalSalesTransaction() {
        double totSalesTx = 0d;
        for (Item lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
        }
        return totSalesTx ;
    }

    public double getDiscount() {
        double discount = 0d;
        for (Item lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            double realPrice = lineItem.totalAmount() + salesTax;
            discount +=(1- lineItem.getDiscount()) * realPrice;
        }
        return discount;
    }
}
