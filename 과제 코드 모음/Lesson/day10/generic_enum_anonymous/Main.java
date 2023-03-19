package Lesson.day10.generic_enum_anonymous;

import java.text.*;
import java.util.*;
import Lesson.day10.generic_enum_anonymous.StrongBox.KeyType;

public class Main {
    public static void main(String[] args) throws InterruptedException, ParseException {
        List<StrongBox<String>> boxes = new ArrayList<>();
        boxes.add(new StrongBox<>(KeyType.PADLOCK));
        boxes.add(new StrongBox<>(KeyType.BUTTON));
        boxes.add(new StrongBox<>(KeyType.DIAL));
        boxes.add(new StrongBox<>(KeyType.FINGER));
        for (StrongBox<String> box : boxes) {
            box.put("stone");
            int idx = 0;
            while (true) {
                idx++;
                String temp = box.get();
                if (temp != null) {
                    System.out.println(box.toString() + ":" + temp + " " + idx);
                    break;
                }
            }
        }

        System.out.println("-------------------------------------------");

        StrongBox<String> box = new StrongBox<>(KeyType.PADLOCK);
        box.put("stone");
        int idx = 0;
        while (true) {
            idx++;
            String temp = box.get();
            System.out.println(temp + " " + idx);
            if (temp != null) {
                break;
            }
        }
    }
}
