package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    private static String TITLE = "======Printing Orders======\n";


    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(TITLE);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        printItems(output, order);
        order.printFooter(output);

        return output.toString();
    }

    private static void printItems(StringBuilder output, Order order) {
        for (Item item : order.getLineItems()) {
            output.append(item.printTo());
        }
    }
}
