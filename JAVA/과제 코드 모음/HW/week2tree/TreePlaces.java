package HW.week2tree;

// 나무의 모임을 나타내는 객체입니다.
public class TreePlaces {
    // 나무가 몇 그루인지 저장하는 변수입니다.
    private int number;
    // 각각의 나무들을 저장하는 변수입니다.
    // 나무의 좌표는 계산 후엔 필요없으므로, 나무들의 소음여부만을 저장합니다.
    private String[] trees;

    // 몇 그루의 나무를 저장할지를 통해 나무 모임 객체를 생성합니다. 
    public TreePlaces(int number) {
        this.number = number;
    }

    // 나무가 몇 그루인지 그 값을 변경할 수 있는 메소드입니다.
    public void setNumber(int input) {
        this.number = input;
    }

    // 나무가 몇 그루인지 그 값을 반환하는 메소드입니다.
    public int getNumber() {
        return this.number;
    }

    // 공사장 객체를 입력받아 각각의 나무들의 소음여부를 저장하는 메소드입니다.
    public void setTrees(ConstructionPlace constructionplace) {
        String[] result = new String[this.number];
        // 나무의 수 만큼 반복합니다.
        for (int k = 0; k < this.number; k++) {
            // 새로운 나무 객체를 생성합니다.
            Tree tree = new Tree(Getter.getLine());
            // 해당 나무 객체의 소음여부를 계산합니다.
            tree.setNoisy(constructionplace);
            // 소음이 들리면 "noisy"를, 들리지 않으면 "silent"를 저장합니다.
            if (tree.getNoisy()) {
                result[k] = "noisy";
            } else {
                result[k] = "silent";
            }
        }
        this.trees = result;
    }

    // 저장된 나무들의 소음여부를 반환하는 메소드입니다.
    public String[] getTrees() {
        return this.trees;
    }
}
