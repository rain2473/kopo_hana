package Lesson.day08.twelfth;

public abstract class IntangibleAsset extends Asset {
    private String relatedLaws;

    public IntangibleAsset(String name, int price, String relatedLaws) {
        super(name, price);
        this.relatedLaws = relatedLaws;
    }

    public String getRelatedLaws() {
        return relatedLaws;
    }
}
