package HW.week2tree;

import java.util.Scanner;

// 변수를 입력받을 때 사용하는 객체입니다.
// 오버라이딩이 발생하면 안되므로 final을 선언합니다.
public final class Getter {
    // 스캐너를 main 메소드에서 선언하는 것은 cool하지 못하므로 이 인터페이스에서 선언하여 재사용합니다.
    // scanner가 변하면 문제가 발생하므로 private로 선언합니다.
    private static final Scanner scanner = new Scanner(System.in);

    // 인스턴스를 생성하면 안되므로, 생성자를 private로 선언합니다.
    private Getter() {}

    // 입력을 한줄씩 받아 문자열로 반환하는 메소드 입니다.
    public static String getLine() {
        return scanner.nextLine();
    }
}
