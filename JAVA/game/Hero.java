package game;

public class Hero {
    static final int HP_MAX = 50; // final 붙였어야함
    static final int MP_MAX = 10; // final 붙였어야함
    static int Money;

    String name;
    private int hp = Hero.HP_MAX;
    Sword sword;
    static int money;
    
    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public Hero(String name) {
        this(name, Hero.HP_MAX);
    }

    public Hero() {
        this("NONAME", Hero.HP_MAX);
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP() {
        return this.hp;
    }

    void bye() {
        System.out.println("용자는 이별을 고했다");
    }

    void die() {
        System.out.println(this.name + "는 죽었다");
        System.out.println("Game Over");
    }

    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "는 잠을 자고 회복했다!");
    }

    void attack(Mushroom enemy) {
        System.out.println(this.name + "의 공격!");
        System.out.println("괴물 버섯" + enemy.getSuffix() + "로부터 2포인트의 반격을 받았다");
        this.hp -= 2;
        if (this.hp <= 0) {
            this.die();
        }
    }
}