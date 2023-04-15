package Lesson.day04.fifth;

import java.util.*;

public class Quiz2 {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        showOutput(determine(getInputs()));
    }
    
    public static int[] getInputs() {
        String[] inputs = scanner.nextLine().split(" ");
        scanner.close();
        int count = inputs.length;
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            answer[i] = Integer.parseInt(inputs[i]);
        }
        return answer;
    }

    public static String determine(int[] answer) {
        String result = "YES";
        int sum = 0;
        for (int num : answer) {
            sum += num;
        }
        if (sum % 2 == 0) {
            result = "NO";
        }
        return result;
    }

    public static void showOutput(String result) {
        System.out.println(result);
    }
}
