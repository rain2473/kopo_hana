package Lesson.day11.fifteenth;

public class Person {
    int age;

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("나이는음수가될수없음.지정한값=" + age);
        }
        this.age = age;
        // 문제가 없을 경우,필드에 값을 설정
    }
}
