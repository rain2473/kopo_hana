package Lesson.day11.fifteenth;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("data.txt")) {
            System.out.println("시작");
            something();
            fw.write("hello!!");
            System.out.println("끝");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void something() throws InterruptedException {
        Thread.sleep(3000);
    }
}
