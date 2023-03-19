package HW.week2tree;

// 결과물을 출력할 때 사용하는 객체입니다.
// 오버라이딩이 발생하면 안되므로 final을 선언합니다.
public final class Viewer {
    // 인스턴스를 생성하면 안되므로, 생성자를 private로 선언합니다.
    private Viewer() {}

    // 문자열 배열을 입력받아 이를 출력하는 메소드 입니다.
    public static void showOutputs(String[] answer) {
        for (String output : answer) {
            System.out.println(output);
        }
    }
}
