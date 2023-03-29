package HW.week2tree;

public class Main {
    public static void main(String[] args) {
        // 공사장 객체의 특성을 입력받아 인스턴스를 생성합니다.
        ConstructionPlace constructionsplace = new ConstructionPlace(Getter.getLine());
        // 나무 모임 객체의 특성(나무의 수)를 입력받아 인스턴스를 생성합니다.
        TreePlaces trees = new TreePlaces(Convertor.String2Int(Getter.getLine()));
        // 각각의 나무의 좌표를 입력받아 그 결과를 저장합니다.
        trees.setTrees(constructionsplace);
        // 결과를 보여줍니다.
        Viewer.showOutputs(trees.getTrees());
    }
}
