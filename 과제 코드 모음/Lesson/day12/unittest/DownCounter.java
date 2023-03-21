package Lesson.day12.unittest;

public class DownCounter implements Countable {
    private int count = 0;

    public DownCounter(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public int count() {
        return this.count--;
    }
}
