package Lesson.day08.eleventh;

// 11-3 Mushroom 클래스를 이용해 다음 사양을 따르는 PoisonMushroom 클래스를 작성하시오
// 괴물 독버섯(PoisonMushroom) 는, 괴물버섯 (Mushroom) 중에서도 특히 “독 공격" 이 되는 것
public class PoisonMushroom extends Mushroom {
    private int poison;

    // PoisonMushroom 는 아래의 코드로 인스턴스화 되는 클래스임
    // PoisonMushroom poisonMushroom = new PoisonMushroom(‘A’);
    public PoisonMushroom(char suffix) {
        super(suffix);
        // PoisonMushroom는 독 공격이 가능한 남은 횟수를 int 형 필드를 가지고 있고 초기값은 5 이다
        this.poison = 5;
    }

    @Override
    // PoisonMushroom는 attack() 메소드가 호출되면 다음 내용의 공격을 한다
    // 우선, “보통 괴물버섯과 같은 공격"을 한다
    // “독 공격의 남은 횟수"가 0이 아니면 다음을 추가로 수행한다
    // 화면에 “추가로, 독 포자를 살포했다!” 를 표시
    // 용사의 HP 의 1/5에 해당하는 포인트를 용사의 HP 로부터 감소시키고, “~포인트의 데미지" 라고 표시
    // “독 공격의 남은 횟수" 를 1 감소 시킨다
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
