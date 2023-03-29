package Lesson.day05.sixth;

import java.lang.Thread;

public class Exam6_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("3초간 기다림!");

        // sleep은 ms 단위이므로 3초 대기하려면 3000 넣어야함
        Thread.sleep(3000);

        System.out.println("끝");
    }
}
