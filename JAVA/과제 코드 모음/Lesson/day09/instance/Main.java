package Lesson.day09.instance;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();

        str.add("이동학");
        str.add("박경덕");
        str.add("강태근");
        str.add("최유림");

        Collections.sort(str);
        System.out.println(str);

        List<Integer> num = new ArrayList<>();

        num.add(0);
        num.add(12);
        num.add(34);
        num.add(5);

        Collections.sort(num);
        System.out.println(num);

        List<Student> students = new ArrayList<>();

        students.add(new Student(0, "이동학"));
        students.add(new Student(1, "박경덕"));
        students.add(new Student(2, "강태근"));
        students.add(new Student(3, "최유림"));

        Collections.sort(students);

        for (Student st : students) {
            System.out.println(st.getName());
        }

    }
}
