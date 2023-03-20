package Lesson.day11.fifteenth;

import java.io.IOException;

public class Exam15_4 {
    public static void main(String[] args) {
        try {
            System.out.println("프로그램 시작");
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
