package Lesson.day08.eleventh;

public class Mushroom {
    int hp = 50;
    private char suffix;

    public Mushroom(char suffix) {
        this.suffix = suffix;
    }

    public char getSuffix() {
        return this.suffix;
    }

    void attack(Hero hero) {
        System.out.println("괴물 버섯 " + this.suffix + "의 공격!");
        System.out.println("10의 데미지!");
        hero.setHP(hero.getHP() - 10);
    }

    void run() {
        System.out.println("괴물 버섯 " + this.suffix + "는 도망갔다!");
    }

    void sit(int sec) {

    }

    void sleep() {

    }
}
