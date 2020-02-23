package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.Discount;

import java.util.Date;
import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<Item> items;
    private static String SALES_TAX = "Sales Tax";
    private static String TOTAL_AMOUNT = "Total Amount";
    private static String DISCOUNT = "Discount";
    private Date date;
    private Discount discount;

    public Order(String name, String address, List<Item> items) {
        this(name, address, items, new Date());
    }

    public Order(String name, String address, List<Item> items, Date date) {
        this.name = name;
        this.address = address;
        this.items = items;
        this.date = date;
        this.discount = new Discount(this.date);
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
        return total;
    }

    public double getTotalSalesTransaction() {
        double totSalesTx = 0d;
        for (Item lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
        }
        return totSalesTx;
    }

    public void printFooter(StringBuilder output) {
        output.append(SALES_TAX).append('\t').append(getTotalSalesTransaction()).append("\n");
        double total = getTotal();
        if (discount.isDiscount()) {
            double discountPrice = total - discount.getDiscount() * total;
            output.append(DISCOUNT).append('\t').append(Math.round(discountPrice * 100) * 0.01d).append("\n");
            total *= discount.getDiscount();
        }
        output.append(TOTAL_AMOUNT).append('\t').append(Math.round(total * 100) * 0.01d);
    }
}
