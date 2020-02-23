package cc.xpbootcamp.warmup.cashier.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static String[] day = new String[]{"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
    public static String getChineseWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return day[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
