package HW.week2tree;

public class Main {
    public static void main(String[] args) {
        ConstructionPlace constructionsplace = new ConstructionPlace(Getter.getLine());
        TreePlaces trees = new TreePlaces(Convertor.String2Int(Getter.getLine()));
        trees.setTrees(constructionsplace);
        Viewer.showOutputs(trees.getTrees());
    }
}