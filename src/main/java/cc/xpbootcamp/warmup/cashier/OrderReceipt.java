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

        double totalSalesTransaction = calculateTotalSalesTransaction(order);
        double total = calculateTotal(order);
        printItems(output, order);

        output.append("Sales Tax").append('\t').append(totalSalesTransaction);
        output.append("Total Amount").append('\t').append(total);

        return output.toString();
    }

    private static void printItems(StringBuilder output, Order order) {
        for (Item lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

        }
    }

    private double calculateTotal(Order order) {
        double total = 0d;
        for (Item lineItem : order.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            total += lineItem.totalAmount() + salesTax;
        }
        return total;
    }

    private double calculateTotalSalesTransaction(Order order) {
        double totSalesTx = 0d;
        for (Item lineItem : order.getLineItems()) {

            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
        }
        return totSalesTx;
    }
}
