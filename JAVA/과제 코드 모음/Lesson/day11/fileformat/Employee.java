package Lesson.day11.fileformat;

import java.io.Serializable;

public class Employee implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age;
    }
}
