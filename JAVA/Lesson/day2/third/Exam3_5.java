package Lesson.day2.third;

import java.util.*;

public class Exam3_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[메뉴] 1:검색 2:등록 3:삭제 4:변경 >");
        int selected = scanner.nextInt();
        scanner.close();
        switch (selected) {
            case 1:
                System.out.println("검색합니다");
                break;
            case 2:
                System.out.println("등록합니다");
                break;
            case 3:
                System.out.println("삭제합니다");
                break;
            case 4:
                System.out.println("변경합니다");
                break;
            default: {
            }
        }
    }
}
