package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.Discount;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<Item>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Item> lineItems = new ArrayList<Item>() {{
            add(new Item("milk", 10.0, 2));
            add(new Item("biscuits", 5.0, 5));
            add(new Item("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationAndDiscount() throws ParseException {

        List<Item> lineItems = new ArrayList<Item>() {{
            add(new Item("biscuits", 21.5, 2));
            add(new Item("chocolate", 10, 1));
        }};
        OrderReceipt receipt =
                new OrderReceipt(
                        new Order(null,
                                null,
                                lineItems,
                                new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19")
                        ));

        String output = receipt.printReceipt();

        assertThat(output, containsString("biscuits\t21.5\t2\t43.0\n"));
        assertThat(output, containsString("chocolate\t10.0\t1\t10.0\n"));
        assertThat(output, containsString("Sales Tax\t5.3"));
        assertThat(output, containsString("Discount\t1.17"));
        assertThat(output, containsString("Total Amount\t57.13"));
    }

}
