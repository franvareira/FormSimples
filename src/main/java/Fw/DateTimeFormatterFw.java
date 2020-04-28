package Fw;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatterFw {
    public static String getTime() {
        Date date =  new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter =  new SimpleDateFormat("HHmmss");
        return formatter.format(ts);
    }



}
