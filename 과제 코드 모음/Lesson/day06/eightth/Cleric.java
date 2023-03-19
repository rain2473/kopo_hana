package Lesson.day06.eightth;

import java.util.Random;

// 연습문제 8-1
// 현실세계의 성직자 “클레릭" 를 표현하는 클래스 Cleric 를 작성 하시오.
// 속성이나 동작은 선언 할 필요 없습니다. (속은 아무것도 작성하지 않아도 됨)
public class Cleric {
    // 연습문제 8-2
    // Cleric 클래스에 “이름", “HP”, “최대 HP”, “MP”, “최대 MP”를 속성으로 추가 하시오.
    // 또한 HP와 최대 HP는 정수로 초기치 50, MP와 최대 MP는 정수로 초기치 10으로 하고, 최대 HP와 최대 MP는 상수 필드로 선언 하시오.
    String name;

    final int hpMax = 50; // final 붙였어야함
    final int mpMax = 10; // final 붙였어야함
    int hp = hpMax; // 수정을 용이하게 재사용해야함
    int mp = mpMax; // 수정을 용이하게 재사용해야함

    // 연습문제 8-3
    // 성직자는 “셀프 에이드" 라는 마법을 사용할 수 있고, MP를 5소비하는 것으로 자신의 HP 를 최대 HP 까지 회복할 수 있다.
    // Cleric 클래스에 “selfAid()” 메소드를 추가 하시오. 이 메소드는 인수가 없고, 리턴 값도 없다.
    void selfAid() {
        if (mp < 5) {
            System.out.println("mp가 부족합니다!"); // 프린트문은 사용 X
        } else {
            System.out.println("selfaid를 실행합니다!\nhp가 최대로 충전 됩니다!"); // 프린트문은 사용 X
            this.hp = hpMax;
            this.mp -= 5;
        }
    }

    // 연습문제 8-4
    // 성직자는 “기도하기" (pray) 라는 행동을 취할 수 있고, 자신의 MP를 회복한다. 단, 최대 MP 보다 더 회복하는 것은 불가능하다.
    // 회복량은 기도한 시간(초)에 랜덤하게 0 ~ 2포인트의 보정을 한 양이다 (3초 기도하면 회복량은 3 ~ 5 포인트).
    // Cleric 클래스에 “pray()” 메소드를 추가하시오. 이 메소드는 인수에 “기도할 시간(초)"를 지정할 수 있고, 리턴 값은 “실제로 회복된 MP 양" 을 반환한다.
    int pray(int sec) {
        Random random = new Random();
        int mpRecovery = random.nextInt(3) + sec;
        if (mpRecovery > mpMax - this.mp) {
            mpRecovery = mpMax - this.mp;
        }
        this.mp += mpRecovery;
        System.out.println("pray를 실행합니다!\n mp가 " + mpRecovery + "만큼 회복됩니다!"); // 프린트문은 사용 X
        return mpRecovery;
    }
}
