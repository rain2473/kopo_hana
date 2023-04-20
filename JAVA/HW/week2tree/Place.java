package HW.week2tree;

// 좌표를 갖는 '공간'이라는 추상적인 개념을 의미하는 객체입니다.
// 인스턴스를 생성하면 안되므로 abstract을 채택합니다.
public abstract class Place {
    private int x;
    private int y;
    private int[] coordinate = new int[2];

    // 좌표값을 선언/변경하는 메소드입니다.
    // 정수형 배열을 입력받습니다.
    public void setCoordinate(int[] inputs) {
        this.coordinate = inputs;
        this.x = inputs[0];
        this.y = inputs[1];
    }

    // 문자열을 입력받습니다.
    public void setCoordinate(String input) {
        setCoordinate(Convertor.string2IntArray(input));
    }

    // 좌표를 정수형 배열로 반환하는 메소드입니다.
    public int[] getCoordinate() {
        return this.coordinate;
    }

    // x좌표를 변경하는 메소드입니다.
    public void changeX(int x) {
        this.x = x;
        this.coordinate[0] = x;
    }

    // y좌표를 변경하는 메소드입니다.
    public void changeY(int y) {
        this.y = y;
        this.coordinate[1] = y;
    }

    // x좌표를 정수형으로 반환하는 메소드입니다.
    public int getX() {
        return this.x;
    }

    // y좌표를 정수형으로 반환하는 메소드입니다.
    public int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String msg = "좌표 : " + this.x + ", " + this.y;
        return msg;
    }
}
