package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totalSalesTransaction = order.getTotalSalesTransaction();
        double total = order.getTotal();

        printItems(output, order);

        output.append("Sales Tax").append('\t').append(totalSalesTransaction);
        output.append("Total Amount").append('\t').append(total);

        return output.toString();
    }

    private static void printItems(StringBuilder output, Order order) {
        for (Item item : order.getLineItems()) {
            output.append(item.printTo());
        }
    }
}
