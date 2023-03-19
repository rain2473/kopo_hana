package HW.week2tree;

// 공사장이라는 객체를 의미하는 class입니다.
public class ConstructionPlace extends Place {
    // 소음의 크기 즉, 소음이 적용되는 반경을 의미하는 변수입니다.
    private int noise;

    // 공사장의 특성을 입력받아 이를 생성하는 생성자입니다.
    public ConstructionPlace(String input) {
        // x, y 좌표를 설정합니다.
        this.setCoordinate(Convertor.string2IntArray(input, 0, 1));
        // 소음의 크기를 설정합니다.
        this.setNoise(Convertor.intOfString(input, 2));
    }

    // 소음의 크기를 반환받는 메소드입니다.
    public int getNoise() {
        return noise;
    }

    // 소음의 크기를 설정하는 메소드입니다.
    public void setNoise(int input) {
        this.noise = input;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", 소음범위 : " + noise;
    }


}
