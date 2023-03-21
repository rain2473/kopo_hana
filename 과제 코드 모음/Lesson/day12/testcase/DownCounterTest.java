package Lesson.day12.testcase;

import static org.junit.Assert.*;
import org.junit.Test;
import Lesson.day12.unittest.DownCounter;

public class DownCounterTest {
    @Test
    public void constructor_test() {
        DownCounter downCounter = new DownCounter(30000);
        assertEquals(30000, downCounter.getCount());
    }

    @Test
    public void setCount_test() {
        DownCounter downCounter = new DownCounter(30000);
        assertEquals(30000, downCounter.getCount());
        downCounter.setCount(1000);
        assertEquals(1000, downCounter.getCount());
        downCounter.setCount(100);
        assertEquals(100, downCounter.getCount());
    }

    @Test
    public void getCount_test() {
        DownCounter downCounter = new DownCounter(30000);
        assertEquals(30000, downCounter.getCount());
        downCounter.setCount(1000);
        assertEquals(1000, downCounter.getCount());
        downCounter.setCount(100);
        assertEquals(100, downCounter.getCount());
    }

    @Test
    public void count_test() {
        DownCounter downCounter = new DownCounter(30000);
        downCounter.count();
        assertEquals(29999, downCounter.getCount());
        downCounter.count();
        assertEquals(29998, downCounter.getCount());
        downCounter.setCount(1000);
        downCounter.count();
        assertEquals(999, downCounter.getCount());
        downCounter.setCount(100);
        downCounter.count();
        assertEquals(99, downCounter.getCount());
    }
}
