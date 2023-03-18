package HW.week2tree;

public class Convertor {
    public static String[] string2StringArray(String input) {
        String[] result = input.split(" ");
        return result;
    }
    
    public static int[] string2IntArray(String input, int start, int end) {
        String[] strings = string2StringArray(input);
        int[] result = new int[strings.length - end];
        for (int i = start; i < strings.length - end; i++) {
            result[i] = String2Int(strings[i]);
        }
        return result;
    }
    
    public static String intArray2String(int[] inputs, int start, int end) {
        String[] strings = new String[inputs.length - end];
        for (int i = start; i < inputs.length - end; i++) {
            strings[i] = String.valueOf(inputs[i]);
        }
        String result = String.join(" ", strings);
        return result;
    }
    
    public static int[] string2IntArray(String input) {
        return string2IntArray(input, 0, 0);
    }
    
    public static String intArray2String(int[] inputs) {
        return intArray2String(inputs, 0, 0);
    }
    
    public static int partOfString(String input, int idx) {
        String[] strings = string2StringArray(input);
        return String2Int(strings[idx]);
    }
    
    public static int String2Int(String input) {
        return Integer.parseInt(input);
    }
    
}
