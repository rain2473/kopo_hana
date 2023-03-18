package HW.week2tree;

public class TreePlaces {
    private int number;
    private String[] trees;
    
    public TreePlaces(int number) {
        this.number = number;
    }

    public void setNumber(int input) {
        this.number = input;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setTrees(ConstructionPlace constructionplace) {
        String[] result = new String[this.number];
        for (int k = 0; k < this.number; k++) {
            Tree tree = new Tree(Getter.getLine());
            tree.setNoisy(constructionplace);
            if (tree.getNoisy()) {
                result[k] = "noisy";
            } else {
                result[k] = "silent";
            }
        }
        this.trees = result;
    }
    
    public String[] getTrees() {
        return this.trees;
    }
}
