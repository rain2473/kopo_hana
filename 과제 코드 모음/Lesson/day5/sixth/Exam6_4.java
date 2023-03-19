package Lesson.day5.sixth;

import java.util.*;

public class Exam6_4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        double PI = Math.PI;
        System.out.println("던질 횟수를 입력해 주세요");
        long tries = scanner.nextInt();
        scanner.close();
        int hits = 0;

        for (int k = 0; k < tries; k++) {
            double x = 2 * random.nextDouble() - 1;
            double y = 2 * random.nextDouble() - 1;

            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                hits++;
            }
        }
        double piEstimate = (4 * hits) / (double) tries;
        double error = Math.abs(1 - piEstimate / PI) * 100;
        System.out.println("PI의 이론값 : " + PI);
        System.out.println("PI의 실험값 : " + piEstimate);
        System.out.println("오차율 : " + error + "%");
    }
}
