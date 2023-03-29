package game;

public class Dancer extends Character implements Human{
    public Dancer(String name, int hp) {
        super(name, hp);
        // TODO Auto-generated constructor stub
    }

    public void dance() {
        System.out.println("춤 춰 버리기~~");
    }
    @Override
    public void attack(Mushroom enemy) {
        System.out.println("공격해 버리기~~");
    }

    @Override
    public void talk() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void watch() {
        // TODO Auto-generated method stub
        
    }
}
