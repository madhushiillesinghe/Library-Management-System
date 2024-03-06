package lk.ijse.library.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtil {

    public static String dateNow() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    public static String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(new Date()) ;
    }


}
