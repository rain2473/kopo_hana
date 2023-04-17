package Lesson.day2.third;

import java.util.*;

public class Exam3_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random =new java.util.Random();
        // 1. 화면에 "[숫자 맞추기 게임]"을 표시한다.
        System.out.println("[숫자 맞추기 게임]");
        // 2. 0부터 9까지의 정수 중에서 랜덤하게 수를 1개 생성해서 변수 answer에 대입한다.
        int answer = random.nextInt(10);
        // 3. for문을 이용해 "5회 반복 하는 루프"를 만든다.
        for (int i = 0; i < 5; i++) {
            // 아래의 4.~7. 은 루프 안에 기술한다.
            // 4. 화면에 "0 ~ 9 사이의 숫자를 입력 하세요"를 표시한다
            System.out.println("0 ~ 9 사이의 숫자를 입력 하세요");
            // 5. 숫자를 입력해, 변수 number에 대입한다
            int number = scanner.nextInt();
            scanner.nextLine();
            // 6. 만약 변수 number 이 변수 answer 와 같으면 “정답!” 이라고 화면에 표시하고 반복을 종료
            if (number == answer) {
                System.out.println("정답!");
                break;
                // 7. 만약 변수 number 이 변수 answer 와 같지 않으면 “다릅니다"를 표시한다
            } else {
                System.out.println("다릅니다");
            }
        }
        scanner.close();
        // 8. 반복 블록의 바깥에, “게임을 종료합니다" 라고 화면에 표시한다.
        System.out.println("게임을 종료합니다");
    }
}
