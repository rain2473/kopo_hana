package Lesson.day7.collections;

import java.util.*;

public class ExamCollections_3 {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person();
        person1.name = "홍길동";
        Person person2 = new Person();
        person2.name = "한석봉";

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(person1.name, 20);
        hashMap.put(person2.name, 25);
        for (String name : hashMap.keySet()) {
            System.out.println(name + "의 나이는 " + hashMap.get(name) + "살");
        }
    }
}
