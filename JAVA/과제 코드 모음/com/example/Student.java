package com.example;

import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int number;
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name); //name으로 오름 차순 정렬
    }
    
    public Student(int number, String name) {
        setName(name);
        setNumber(number);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
//    public int campare(Student o1, Student o2) {
//        return Integer.compare(o1.number, o2.number);
//    }
}
