package Lesson.day8.eleventh;

public class Main {

    public static void main(String[] args) {
        Hero heroo = new Hero("영우웅", 100);
        Wizard wizardA = new Wizard("해리포터", 50, 40, "불사조 깃털", 10);
        System.out.println(heroo.getHP());
        wizardA.heal(heroo);
        System.out.println(heroo.getHP());
    }

}
