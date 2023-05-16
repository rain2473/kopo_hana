package game;

import java.util.Random;
import java.lang.Math;

public class Cleric {
    static final int HP_MAX = 50; // final 붙였어야함
    static final int MP_MAX = 10; // final 붙였어야함

    String name;

    int hp = Cleric.HP_MAX; // 수정을 용이하게 재사용해야함
    int mp = Cleric.MP_MAX; // 수정을 용이하게 재사용해야함

    Random random = new Random(); // 재사용이 되기 때문에 필드에 선언하는게 나음

    public Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public Cleric(String name, int hp) {
        this(name, hp, Cleric.MP_MAX);
    }

    public Cleric(String name) {
        this(name, Cleric.HP_MAX, Cleric.MP_MAX);
    }


    void selfAid() {
        if (mp >= 5) {
            this.hp = Cleric.HP_MAX;
            this.mp -= 5;
        }
    }

    int pray(int sec) {
        int mpRecovery = random.nextInt(3) + sec;
        this.mp += mpRecovery;
        this.mp = Math.min(this.mp, Cleric.MP_MAX);
        return mpRecovery;
    }
}
