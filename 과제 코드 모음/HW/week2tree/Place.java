package HW.week2tree;

public abstract class Place {
    private int x;
    private int y;
    private int[] coordinate = new int[2];
    
    public void setCoordinate(String input) {
        int[] coordinate = Convertor.string2IntArray(input);
        this.coordinate = coordinate;
        this.x = coordinate[0];
        this.y = coordinate[1];
    }
    
    public void setCoordinate(int[] inputs) {
        int[] coordinate = inputs;
        this.coordinate = coordinate;
        this.x = coordinate[0];
        this.y = coordinate[1];
    }
    
    public int[] getCoordinate() {
        return this.coordinate;
    }
    
    public void changeX(int x) {
        this.x = x;
        this.coordinate[0] = x;
    }
    
    public void setY(int y) {
        this.y = y;
        this.coordinate[1] = y;
    }
    
    public int getX() {
        return this.x;
    }
    
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
        String msg = "좌표 : "+this.x+", "+this.y;
        return msg;
    }
    
    
}
