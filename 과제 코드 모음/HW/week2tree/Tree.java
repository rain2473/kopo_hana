package HW.week2tree;

import java.lang.Math;

// 나무라는 객체를 의미하는 class입니다.
public class Tree extends Place {
    // 해당 나무에서 소음이 들리는지를 의미하는 변수입니다.
    private boolean noisy;

    // 나무의 특성을 입력받아 이를 생성하는 생성자입니다.
    public Tree(String input) {
        super.setCoordinate(input);
    }

    // 공사장 객체를 입력받아 소음여부를 설정하는 메소드입니다.
    public void setNoisy(ConstructionPlace constructionplace) {
        // 계산식의 좌변입니다.
        // 나무와 공사장의 거리의 제곱을 구합니다.
        double left = Math.pow((this.getX() - constructionplace.getX()), 2)
                + Math.pow((this.getY() - constructionplace.getY()), 2);
        // 계산식의 우변입니다.
        // 소음반경의 제곱을 구합니다.
        double right = Math.pow(constructionplace.getNoise(), 2);
        // 원의공식을 이용하여 소음여부를 설정합니다.
        if (left <= right) {
            // 원의 내부에 있으면 (소음반경 이내면) 소음을 참으로 둡니다.
            this.noisy = true;
        } else {
            // 원의 외부에 있으면 (소음반경 밖이면) 소음을 거짓으로 둡니다.
            this.noisy = false;
        }
    }

    // 소음여부를 반환하는 메소드입니다.
    public boolean getNoisy() {
        return this.noisy;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", 소음 : " + noisy;
    }
}
