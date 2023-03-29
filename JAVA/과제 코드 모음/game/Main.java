package game;

public class Main {
    public static void main(String[] args) {
        // 용사 캐릭터 생성
        Hero hero = new Hero("영웅");
        // 생성된 용사 캐릭터 속성 부여
        // System.out.println("용사 " + hero.name + "을 생성했습니다!");

        // 버섯 2마리 생성
        Mushroom mushroom1 = new Mushroom('A');
        mushroom1.hp = 50;

        // 동작을 지시
        // hero.sleep();
        // mushroom1.run();

        //
        // Cleric ClericA = new Cleric("아서스", 40, 5);
        // Cleric ClericB = new Cleric("아서스", 40);
        // Cleric ClericC = new Cleric("아서스");
        //
        // System.out.println(ClericA.name + ClericA.hp + ClericA.mp);
        // System.out.println(ClericB.name + ClericB.hp + ClericB.mp);
        // System.out.println(ClericC.name + ClericC.hp + ClericC.mp);

        // Wizard wizardA = new Wizard("해리포터", 50, 40);
        // System.out.println(wizardA.getHP());
        Hero heroo = new Hero("영우웅", 100);
        System.out.println("영우웅의 HP : " + heroo.getHP());
        PoisonMushroom mushroom2 = new PoisonMushroom('B');
        mushroom2.attack(heroo);
    }
    
    Life wizard = new Wizard("해리포타");
    Life mushroom = new Mushroom('K');

}
