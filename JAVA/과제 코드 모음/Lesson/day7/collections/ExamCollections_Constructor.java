package Lesson.day7.collections;

import java.util.*;

public class ExamCollections_Constructor {
    public static void main(String[] args) throws Exception {
      Person person1 = new Person("홍길동");
      Person person2 = new Person("한석봉");

      // 2번 문제
      List<Person> arrayList = new ArrayList<>();
      
      arrayList.add(person1);
      arrayList.add(person2);
      for (Person person : arrayList) {
          System.out.println(person.name);
      }

      // 3번 문제
      Map<String, Integer> hashMap = new HashMap<>();
      hashMap.put(person1.name, 20);
      hashMap.put(person2.name, 25);
      for (String name : hashMap.keySet()) {
          System.out.println(name + "의 나이는 " + hashMap.get(name) + "살");
      }

  }
}
