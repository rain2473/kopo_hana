package Lesson.day5.sixth;

public class Exam6_2 {
    public static void main(String[] args) throws Exception {
        String special = "\t";
        for (int i = 2; i < 10; i++) {
            for (int k = 1; k < 10; k++) {
                System.out.printf("%d * %d = %2d", k, i, k * i);
                if (k == 9) {
                    special = "\n";
                } else {
                    special = "\t";
                }
                System.out.printf("%s", special);
            }
        }
    }
}
