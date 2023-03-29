package Lesson.day12.testcase;

import static org.junit.Assert.*;
import org.junit.Test;
import Lesson.day12.unittest.UpCounter;

public class UpCounterTest {
    @Test
    public void constructor_test() {
        UpCounter upCounter = new UpCounter(30000);
        assertEquals(30000, upCounter.getCount());
    }

    @Test
    public void setCount_test() {
        UpCounter upCounter = new UpCounter(30000);
        assertEquals(30000, upCounter.getCount());
        upCounter.setCount(1000);
        assertEquals(1000, upCounter.getCount());
        upCounter.setCount(100);
        assertEquals(100, upCounter.getCount());
    }

    @Test
    public void getCount_test() {
        UpCounter upCounter = new UpCounter(30000);
        assertEquals(30000, upCounter.getCount());
        upCounter.setCount(1000);
        assertEquals(1000, upCounter.getCount());
        upCounter.setCount(100);
        assertEquals(100, upCounter.getCount());
    }

    @Test
    public void count_test() {
        UpCounter upCounter = new UpCounter(30000);
        upCounter.count();
        assertEquals(30001, upCounter.getCount());
        upCounter.count();
        assertEquals(30002, upCounter.getCount());
        upCounter.setCount(1000);
        upCounter.count();
        assertEquals(1001, upCounter.getCount());
        upCounter.setCount(100);
        upCounter.count();
        assertEquals(101, upCounter.getCount());
    }

}
