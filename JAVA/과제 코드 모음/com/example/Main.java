package com.example;

import java.util.*;
import javax.security.auth.Subject;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        
        num.add(0);
        num.add(12);
        num.add(34);
        num.add(5);
        
        Collections.sort(num);
        System.out.println(num);
        
        List<Student> students = new ArrayList<>();
        
        students.add(new Student(0,"이동학"));
        students.add(new Student(1,"박경덕"));
        students.add(new Student(2,"강태근"));
        students.add(new Student(3,"최유림"));
        
        Collections.sort(students);
        
        for (Student st : students) {
        System.out.println(st.getName());
        }
        
    }
}