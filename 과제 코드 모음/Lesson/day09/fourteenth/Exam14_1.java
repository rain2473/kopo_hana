package Lesson.day09.fourteenth;

import java.text.SimpleDateFormat;
import java.util.*;

public class Exam14_1 {

    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY년 MM월 dd일");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String today = format.format(now);

        System.out.println(today);

        int day = calendar.get(Calendar.DATE);
        day += 100;
        calendar.set(Calendar.DATE, day);
        Date furture = calendar.getTime();
        String furtureDay = format.format(furture);

        System.out.println(furtureDay);
    }
}
