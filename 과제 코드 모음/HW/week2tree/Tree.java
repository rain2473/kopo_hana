package HW.week2tree;

import java.lang.Math;

public class Tree extends Place{
    private boolean noisy;
    
    public Tree(String input) {
        super.setCoordinate(input);
    }
    
    public void setNoisy(ConstructionPlace constructionplace) {
        double left = Math.pow((this.getX() - constructionplace.getX()), 2) + Math.pow((this.getY() - constructionplace.getY()), 2);
        double right = Math.pow(constructionplace.getNoise(), 2);
        if (left <= right) {
            this.noisy = true;
        } else {
            this.noisy = false;
        }
    } 
    
    public boolean getNoisy() {
        return this.noisy;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", 소음 : " + noisy;
    }
}