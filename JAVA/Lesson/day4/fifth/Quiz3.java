package Lesson.day4.fifth;

import java.util.*;

public class Quiz3 {
    static Scanner scanner = new Scanner(System.in);
    
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

    public static int[] generate(int[] answer, int count) {
        int[] result = new int[count];
        int d = answer[1];
        result[0] = answer[0];
        for (int i = 1; i < count; i++) {
            result[i] = result[i - 1] + d;
        }
        return result;
    }

    public static int[] generate(int[] answer) {
        return generate(answer, 10);
    }

    public static StringBuilder converte(int[] result) {
        StringBuilder stringbuilder = new StringBuilder("");
        int count = result.length;
        for (int i = 0; i < count; i++) {
            stringbuilder.append(Integer.toString(result[i]));
            if (i != count - 1) {
                stringbuilder.append(" ");
            } else {
                stringbuilder.append("\n");
            }
        }
        return stringbuilder;
    }

    public static void showOutput(StringBuilder stringbuilder) {
        System.out.println(stringbuilder);
    }

    public static void main(String[] args) {
        showOutput(converte(generate(getInputs())));
    }
}
