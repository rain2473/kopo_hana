package Lesson.day2.third;

import java.util.*;

public class Quiz1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringbuilder = new StringBuilder("Hello ");
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String tmp = scanner.nextLine();
            if (i < num - 1) {
                tmp += ",";
            } else {
                tmp += ".";
            }
            stringbuilder.append(tmp);
        }
        scanner.close();
        System.out.println(stringbuilder.toString());
    }
}
