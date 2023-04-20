package game;

public class Wand {
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
