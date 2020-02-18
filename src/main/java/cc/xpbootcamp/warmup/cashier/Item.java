package cc.xpbootcamp.warmup.cashier;

public class Item {
    private String desc;
    private double price;
    private int quantity;
    private double discount;
    public Item(String desc, double price, int quantity,double discount) {
        super();
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public String printTo() {
        return this.getDescription() +
                '\t' +
                this.getPrice() +
                '\t' +
                this.getQuantity() +
                '\t' +
                this.totalAmount() +
                '\n';
    }
}
