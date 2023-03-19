package Lesson.day7.tenth;

public class Wand {
    // 10-1 캡슐화 정석에 따라 필드와 메소드에 대해 접근 지정자를 추가하라.
    // 필드 -> private, 메소드 -> public
    private String name;
    private double power;

    public Wand(String name, double power) {
        setName(name);
        setPower(power);
    }

    public Wand(String name) {
        setName(name);
        setPower(10);
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
    
    // 지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
    public void setPower(double power) {
        if (power < 0.5) {
            throw new IllegalArgumentException("마력은 0.5 이상이어야한다.");
        }
        if (power > 100) {
            throw new IllegalArgumentException("마력은 100 이하이어야한다.");
        }
        this.power = power;
    }

    public double getPower() {
        return this.power;
    }
}
