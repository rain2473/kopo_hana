package BookManager.utillities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateHandler {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    private Calendar calendar = Calendar.getInstance();
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

    public String now() {
        Date now = calendar.getTime();
        return format.format(now);
    }

    public String set(String input) throws ParseException {
        Date setted = setDate(input);
        return format.format(setted);
    }
    
    public String add(String input, int maximumdays) throws ParseException {
        Date setted = setDate(input);
        calendar.setTime(setted);        
        calendar.add(Calendar.DATE, maximumdays);
        Date dueTo = calendar.getTime();
        return format.format(dueTo);
    }
    
    public String sub(String input1, String input2) throws ParseException {
        Date day1 = setDate(input1);
        Date day2 = setDate(input2);
        long period = day1.getTime() - day2.getTime();
        long diffrence = TimeUnit.DAYS.convert(period, TimeUnit.MILLISECONDS);
        return String.valueOf(diffrence);
    }

    private Date setDate(String input) throws ParseException {
        return format.parse(input);
    }

    @SuppressWarnings("deprecation")
	public String age(String input) throws ParseException {
        Date now = calendar.getTime();
        Date set = setDate(input);
        int age = now.getYear() - set.getYear();
        if ((now.getMonth() - set.getMonth()) * 100 + now.getDate() - set.getDate() < 0) {
            age--;
        }
        return String.valueOf(age);
    }
    public void init() {
        Date now = new Date();
        calendar.setTime(now);
    }
}
