package com.java14;

import java.text.*;
import java.util.*;
import com.java14.StrongBox.KeyType;

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
    }
}
