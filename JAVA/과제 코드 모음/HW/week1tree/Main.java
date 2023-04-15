package HW.week1tree;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] firstline = toInteger();
        int[] secondline = toInteger();
        int[] inputs = zipIntArrays(firstline, secondline);
        String[] trees = solution(inputs);
        showOutputs(trees);
    }

    public static int[] toInteger() {
        String[] inputs = scanner.nextLine().split(" ");
        int[] outputs = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            outputs[i] = Integer.parseInt(inputs[i]);
        }
        return outputs;
    }

    public static int[] zipIntArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < result.length; i++) {
            if (i < array1.length) {
                result[i] = array1[i];
            } else {
                result[i] = array2[i - array1.length];
            }
        }
        return result;
    }

    public static String[] solution(int[] inputs) {
        int number = inputs[3];
        String[] result = new String[number];
        for (int k = 0; k < number; k++) {
            int[] newInputs = toInteger();
            int xOfTree = newInputs[0];
            int yOfTree = newInputs[1];
            result[k] = determine(xOfTree, yOfTree, inputs);
        }
        return result;
    }

    public static String determine(int xOfTree, int yOfTree, int[] inputs) {
        int xOfFocus = inputs[0];
        int yOfFocus = inputs[1];
        int radius = inputs[2];
        String result = "silent";
        if (Math.pow((xOfTree - xOfFocus), 2) + Math.pow((yOfTree - yOfFocus), 2) <= Math
                .pow(radius, 2)) {
            result = "noisy";
        }
        return result;
    }

    public static void showOutputs(String[] outputs) {
        for (String output : outputs) {
            System.out.println(output);
        }
    }
}
