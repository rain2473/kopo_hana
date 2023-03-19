package game;

public abstract class Character {
    private String name;
    private int hp;
    
    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    public Character(String name) {
        this(name, 1);
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract void attack(Mushroom enemy);
    
    public int getHP() {
        return this.hp;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
}
