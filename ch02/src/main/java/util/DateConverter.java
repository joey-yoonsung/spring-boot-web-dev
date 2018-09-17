package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateConverter {
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static String fromTimestamp(long timestamp) {
        return format.format(new Date(timestamp));
    }

    private DateConverter() {}
}
