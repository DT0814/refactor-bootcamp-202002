package cc.xpbootcamp.warmup.cashier.utils;

import java.util.Calendar;
import java.util.Date;

public class Discount {
    private Calendar calendar = Calendar.getInstance();

    public Discount(Date date) {
        calendar.setTime(date);
    }

    public boolean isDiscount() {
        return calendar.get(Calendar.DAY_OF_WEEK) == 4;
    }

    public double getDiscount() {
        return 0.98d;
    }
}
