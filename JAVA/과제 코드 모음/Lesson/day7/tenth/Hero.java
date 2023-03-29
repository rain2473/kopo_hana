package Lesson.day7.tenth;

public class Hero {
    // 10-1 캡슐화 정석에 따라 필드와 메소드에 대해 접근 지정자를 추가하라.
    // 필드 -> private, 메소드 -> public
    private static final int HP_MAX = 50;
    private String name;

    private int hp = Hero.HP_MAX;

    public Hero(String name, int hp) {
        setHP(hp);
        setName(name);
    }

    public Hero(String name) {
        this(name, Hero.HP_MAX);
    }
    
    // 10-2 getter와 setter 메소드를 작성하시오
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP() {
        return this.hp;
    }
}
