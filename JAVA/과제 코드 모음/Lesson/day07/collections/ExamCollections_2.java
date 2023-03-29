package Lesson.day07.collections;

import java.util.*;

public class ExamCollections_2 {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person();
        person1.name = "홍길동";
        Person person2 = new Person();
        person2.name = "한석봉";
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(person1);
        arrayList.add(person2);
        for (Person person : arrayList) {
            System.out.println(person.name);
        }
    }
}
