package HW.week2tree;

public class ConstructionPlace extends Place {
    private int noise;

    public ConstructionPlace(String input) {
        int[] coordinate = Convertor.string2IntArray(input, 0, 1);
        super.setCoordinate(coordinate);
        setNoise(Convertor.partOfString(input, 2));
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int input) {
        this.noise = input;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", 소음범위 : " + noise;
    }


}
