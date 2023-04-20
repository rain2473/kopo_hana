package HW.week2tree;

// 타입형 전환에 필요한 메소드들을 정의하는 객체입니다.
// 오버라이딩이 발생하면 안되므로 final을 선언합니다.
public final class Convertor {
    // 인스턴스를 생성하면 안되므로, 생성자를 private로 선언합니다.
    private Convertor() {}

    // 반환형이 문자열인 메소드//

    // 정수를 문자열로 반환하는 메소드 입니다.
    public static String Int2String(int input) {
        return String.valueOf(input);
    }

    // 문자열의 n번째 요소를 문자열로 반환하는 메소드입니다.
    public static String partOfString(String input, int idx) {
        return string2StringArray(input)[idx];
    }

    // 문자열 배열을 입력받아 문자열로 반환하는 메소드 입니다.
    // 반환받고자 하는 시작점과 끝점을 지정할 수 있습니다.
    public static String stirngArray2String(String[] inputs, int start, int end) {
        return String.join(" ", partOfStringArray(inputs, start, end));
    }

    // 문자열 배열을 입력받아 문자열로 반환하는 메소드 입니다.
    public static String stirngArray2String(String[] inputs) {
        return stirngArray2String(inputs, 0, 0);
    }

    // 정수 배열을 입력받아 문자열로 반환하는 메소드 입니다.
    // 반환받고자 하는 시작점과 끝점을 지정할 수 있습니다.
    public static String intArray2String(int[] inputs, int start, int end) {
        return String.join(" ", intArray2StringArray(inputs, start, end));
    }

    // 정수 배열을 입력받아 문자열로 반환하는 메소드 입니다.
    public static String intArray2String(int[] inputs) {
        return intArray2String(inputs, 0, 0);
    }

    // 반환형이 정수인 메소드 //

    // 문자열을 정수로 반환하는 메소드 입니다.
    public static int String2Int(String input) {
        return Integer.parseInt(input);
    }

    // 문자열의 n번째 요소를 정수로 반환하는 메소드입니다.
    public static int intOfString(String input, int idx) {
        return String2Int(partOfString(input, idx));
    }

    // 반환형이 문자열 배열인 메소드 //

    // 문자열을 입력받아 띄어쓰기를 기준으로 잘라 문자열 배열로 반환하는 메소드입니다.
    public static String[] string2StringArray(String input) {
        return input.split(" ");
    }

    // 문자열 배열을 입력받아 시작부분과 끝부분만큼만 잘라 반환하는 메소드입니다.
    public static String[] partOfStringArray(String[] inputs, int start, int end) {
        String[] result = new String[inputs.length - end - start];
        for (int i = 0; i < inputs.length - end; i++) {
            if (i >= start) {
                result[i - start] = inputs[i];
            }
        }
        return result;
    }

    // 정수 배열을 입력받아 문자열 배열로 반환하는 메소드 입니다.
    // 반환받고자 하는 시작점과 끝점을 지정할 수 있습니다.
    public static String[] intArray2StringArray(int[] inputs, int start, int end) {
        String[] result = new String[inputs.length - end];
        for (int i = start; i < inputs.length - end; i++) {
            result[i] = Int2String(inputs[i]);
        }
        return result;
    }

    // 정수 배열을 입력받아 문자열로 반환하는 메소드 입니다.
    public static String[] intArray2StringArray(int[] inputs) {
        return intArray2StringArray(inputs, 0, 0);
    }

    // 반환형이 정수 배열인 메소드 //

    // 문자열 배열을 입력받아 정수배열로 반환하는 메소드 입니다.
    // 반환받고자 하는 시작점과 끝점을 지정할 수 있습니다.
    public static int[] stringArray2IntArray(String[] inputs, int start, int end) {
        int[] result = new int[inputs.length - end - start];
        for (int i = start; i < inputs.length - end; i++) {
            result[i] = String2Int(inputs[i]);
        }
        return result;
    }

    // 문자열 배열을 입력받아 정수배열로 반환하는 메소드 입니다.
    public static int[] stringArray2IntArray(String[] inputs) {
        return stringArray2IntArray(inputs, 0, 0);
    }

    // 문자열을 입력받아 띄어쓰기를 기준으로 잘라 정수 배열로 반환하는 메소드 입니다.
    // 반환받고자 하는 시작점과 끝점을 지정할 수 있습니다.
    public static int[] string2IntArray(String input, int start, int end) {
        return stringArray2IntArray(string2StringArray(input), start, end);
    }

    // 문자열을 입력받아 띄어쓰기를 기준으로 잘라 정수 배열로 반환하는 메소드 입니다.
    public static int[] string2IntArray(String input) {
        return string2IntArray(input, 0, 0);
    }
}
