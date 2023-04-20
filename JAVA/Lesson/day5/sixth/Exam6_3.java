package Lesson.day5.sixth;

public class Exam6_3 {
    public static void main(String[] args) throws Exception {
        String special = " ";
        for (int k = 0; k < 60; k++) {
            for (int i = 1; i < 13; i++) {
                System.out.printf("%2d:%02d", i, k);
                if (i == 12) {
                    special = "\n";
                } else {
                    special = "\t";
                }
                System.out.printf("%s", special);
            }
        }
    }
}
