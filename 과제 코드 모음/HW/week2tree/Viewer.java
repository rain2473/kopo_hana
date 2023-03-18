package HW.week2tree;

// 결과물을 출력할 때 사용하는 객체입니다.
// 인스턴스를 생성하면 안되므로, interface를 채택합니다.
public interface Viewer {
    // 문자열 배열을 입력받아 이를 출력하는 메소드 입니다.
    public static void showOutputs(String[] answer) {
        for (String output : answer) {
            System.out.println(output);
        }
    }
}
