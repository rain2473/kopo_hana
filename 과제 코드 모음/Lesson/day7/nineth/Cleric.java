package Lesson.day7.nineth;

import java.util.*;

public class Cleric {
    // 9-1
    // Cleric 클래스의 정의에는, 각 인스턴스별로 최대 HP와 최대 MP 필드에 정보를 가지고 있다.
    // 하지만, 모든 성직자의 최대 HP와 최대 MP는 정해져 있어, 각 인스턴스가 각각의 정보를 가지는 것은 메모리 낭비이다.
    // 최대 HP, 최대 MP의 필드 선언에 적절한 키워드를 추가해 필드가 각 인스턴스별로 있지 않도록하라.
    static final int HP_MAX = 50;
    static final int MP_MAX = 10;

    String name;
    Random random = new Random();

    int hp = HP_MAX;
    int mp = MP_MAX;

    // 9-2
    // 가능한 한 중복되는 코드가 없도록 생성자를 작성한다
    // 이 클래스는 new Cleric() 과 같이 이름을 지정하지 않는 경우에는 인스턴스화 할 수 없다고 한다.
    
    // 이 클래스는 new Cleric(“아서스", 40, 5) 와 같이, 이름, HP, MP 를 지정하여 인스턴스화 할 수 있다
    Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    // 이 클래스는 new Cleric(“아서스", 35) 와 같이, 이름과 HP만으로 지정하여 인스턴스화 할 수 있다. 이 때, MP는 최대 MP와 같은 값이 초기화 된다
    Cleric(String name, int hp) {
        this(name, hp, MP_MAX);
    }

    // 이 클래스는 new Cleric(“아서스") 와 같이 이름만을 지정하여 인스턴스화 할 수 있다. 이 때, HP 와 MP 는 최대 HP와 최대 MP로 초기화 된다
    Cleric(String name) {
        this(name, HP_MAX, MP_MAX);
    }

    void selfAid() {
        if (mp >= 5) {
            this.hp = HP_MAX;
            this.mp -= 5;
        }
    }

    int pray(int sec) {
        int mpRecovery = random.nextInt(3) + sec;
        this.mp += mpRecovery;
        this.mp = Math.min(this.mp, MP_MAX);
        return mpRecovery;
    }
}
