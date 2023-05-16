package BookManagerDB.utillities;

import java.text.SimpleDateFormat;

public class DateHandler {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    private static DateHandler instance;
    
    private DateHandler() {}

    public static DateHandler getInstance() {
        if (instance == null) {
            synchronized (DateHandler.class) {
                if (instance == null) {
                    instance = new DateHandler();
                }
            }
        }
        return instance;
    }
    
    public SimpleDateFormat getFormat() {
        return format;
    }
}
