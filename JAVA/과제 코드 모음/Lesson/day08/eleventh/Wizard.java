package Lesson.day08.eleventh;

public class Wizard {
    // 10-1 캡슐화 정석에 따라 필드와 메소드에 대해 접근 지정자를 추가하라.
    // 필드 -> private, 메소드 -> public
    private static final int HP_MAX = 50;
    private static final int MP_MAX = 10;
    private String name;

    private int hp = Wizard.HP_MAX;
    private int mp = Wizard.MP_MAX;

    private Wand wand;

    public Wizard(String name, int hp, int mp, String wand, double power) {
        setHP(hp);
        setMP(mp);
        setName(name);
        // 마법사의 지팡이는 null 일 수 없다.
        setWand(wand, power);
    }

    public Wizard(String name, int hp, int mp) {
        // 마법사의 지팡이는 null 일 수 없다.
        this(name, hp, mp, "default wand", 1);
    }

    public Wizard(String name, String wand, double power) {
        // 마법사의 지팡이는 null 일 수 없다.
        this(name, Wizard.HP_MAX, Wizard.MP_MAX, wand, power);
    }

    public Wizard(String name) {
        // 마법사의 지팡이는 null 일 수 없다.
        this(name, Wizard.HP_MAX, Wizard.MP_MAX, "default wand", 1);
    }

    // 10-2 getter와 setter 메소드를 작성하시오
    // 10-3 규칙에 맞게 getter와 setter를 수정하시오.
    // 마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름을 입력해야한다");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("이름은 3글자 이상이어야한다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHP(int hp) {
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    // HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)
    public int getHP() {
        return this.hp;
    }

    // 마법사의 MP는 0 이상이어야 한다.
    public void setMP(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("mp는 0 이상이어야한다.");
        }
        this.mp = mp;
    }

    public int getMP() {
        return this.mp;
    }

    public void setWand(String wand, double power) {
        if (wand == null) {
            throw new IllegalArgumentException("wand는 null일수 없다.");
        }
        this.wand = new Wand(wand, power);
    }

    public Wand getWand() {
        return this.wand;
    }

    // heal 메소드의 컴파일 에러를 해결하라
    void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHP() + recovPoint);
    }
}
