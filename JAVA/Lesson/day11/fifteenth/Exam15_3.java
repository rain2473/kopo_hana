package Lesson.day11.fifteenth;

public class Exam15_3 {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("Three");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
