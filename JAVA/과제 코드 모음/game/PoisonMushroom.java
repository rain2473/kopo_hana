package game;

public class PoisonMushroom extends Mushroom {
    private int poison;

    public PoisonMushroom(char suffix) {
        super(suffix);
        this.poison = 5;
    }

    @Override
    void attack(Hero hero) {
        super.attack(hero);
        if (poison > 0) {
            System.out.println("추가로, 독 포자를 살포했다!");
            System.out.println((int) (hero.getHP() * 0.2) + "포인트의 데미지");
            hero.setHP((int) (hero.getHP() * 0.8));
            poison--;
        }
    }
}
