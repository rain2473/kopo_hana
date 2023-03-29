package Lesson.day3.fourth;

import java.util.Scanner;

public class Exam4_4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 3개짜리 int 형 배열 numbers를 준비하시오. 이 때 초기화는 각각 3, 4, 9 로 합니다.
        int[] numbers = {3, 4, 9};
        // 2. 화면에 “1자리의 숫자를 입력 해 주세요" 라고 표시합니다
        System.out.println("1자리의 숫자를 입력 해 주세요");
        // 3. 다음 코드를 사용해 키보드로부터 숫자를 입력 받아, 변수 input에 대입합니다
        int input = getInt();
        // 4. input값이 3, 4, 9 중 하나와 같다면 “정답!” 이라고 표시합니다
        if (contains(numbers, input)) {
            System.out.println("정답!");
        }
    }

    public static boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    public static int getInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
