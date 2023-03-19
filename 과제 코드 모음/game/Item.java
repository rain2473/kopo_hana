package game;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        setName(name);
        setPrice(price);
    }

    public Item(String name) {
        this(name,0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
