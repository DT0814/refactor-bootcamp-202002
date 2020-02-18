package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    private static String TITLE = "======Printing Orders======\n";
    private static String SALES_TAX = "Sales Tax";
    private static String TOTAL_AMOUNT = "Total Amount";
    private static String DISCOUNT = "Discount";

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(TITLE);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        printItems(output, order);

        output.append(SALES_TAX).append('\t').append(order.getTotalSalesTransaction()).append("\n");
        output.append(DISCOUNT).append('\t').append(order.getDiscount()).append("\n");
        output.append(TOTAL_AMOUNT).append('\t').append(order.getTotal());

        return output.toString();
    }

    private static void printItems(StringBuilder output, Order order) {
        for (Item item : order.getLineItems()) {
            output.append(item.printTo());
        }
    }
}
