package Lesson.day11.fileformat;

import java.io.*;
import java.util.*;

public class Exam_fileformat_1 {
    public static void main(String[] args) throws IOException {
        String fileDir =
                "C:\\Users\\admin\\eclipse-workspace\\JavaExam\\src\\Lesson\\day11\\fileformat\\";
        String fileName = "gradle.properties";
        Reader fr = new FileReader(fileDir + fileName);
        Properties gradle = new Properties();
        gradle.load(fr);
        String msg = gradle.getProperty("android.useAndroidX");
        System.out.println(msg);
    }
}
