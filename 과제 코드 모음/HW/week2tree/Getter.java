package HW.week2tree;

import java.util.Scanner;

// 변수를 입력받을 때 사용하는 객체입니다.
// 인스턴스를 생성하면 안되므로, interface를 채택합니다.
public interface Getter {
    // 스캐너를 main 메소드에서 선언하는 것은 cool하지 못하므로 이 인터페이스에서 선언하여 재사용합니다.
    static Scanner scanner = new Scanner(System.in);

    // 입력을 한줄씩 받아 문자열로 반환하는 메소드 입니다.
    public static String getLine() {
        return scanner.nextLine();
    }
}
