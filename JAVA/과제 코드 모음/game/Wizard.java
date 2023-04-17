package game;

public class Wizard extends Character implements Life{
    private static final int HP_MAX = 50; // final 붙였어야함
    private static final int MP_MAX = 10; // final 붙였어야함
    private String name;

    private int mp = Wizard.MP_MAX; // 수정을 용이하게 재사용해야함

    private Wand wand;

    public Wizard(String name, int hp, int mp, String wand, double power) {
        super(name,hp);
        setMP(mp);
        setWand(wand, power);
    }

    public Wizard(String name, int hp, int mp) {
        this(name, hp, mp, "default wand", 1);
    }

    public Wizard(String name, String wand, double power) {
        this(name, Wizard.HP_MAX, Wizard.MP_MAX, wand, power);
    }

    public Wizard(String name) {
        this(name, Wizard.HP_MAX, Wizard.MP_MAX, "default wand", 1);
    }

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
    
    public void setWand() {
        throw new IllegalArgumentException("wand는 null일수 없다.");
    }

    public Wand getWand() {
        if (this.wand == null) {
            throw new IllegalArgumentException("wand는 null일수 없다.");
        }
        return this.wand;
    }
    
    public void attack(Mushroom enemy) {
        System.out.println("공격!!");
        int basePoint = 10;
        int attackPoint = (int) (basePoint * this.wand.getPower());
        enemy.setHP(enemy.getHP() - attackPoint);
    }

    void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHP() + recovPoint);
    }
}
