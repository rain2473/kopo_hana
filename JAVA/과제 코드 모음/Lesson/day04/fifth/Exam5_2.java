package Lesson.day04.fifth;

public class Exam5_2 {
    public static void email(String title, String address, String text) {
        System.out.println(address + "에 아래의 메일을 송신한다.");
        System.out.println("제목 : " + title);
        System.out.println("본문 : " + text);
    }

    public static void main(String[] args) {
        email("과제", "kopo0022@kopo.ac.kr", "과제 제출합니다");
    }
}
