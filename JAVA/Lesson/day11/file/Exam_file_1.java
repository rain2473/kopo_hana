package Lesson.day11.file;

import java.io.*;

public class Exam_file_1 {
    public static void copyFile(String fileLink, String copyFileLink) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileLink);
                FileOutputStream fos = new FileOutputStream(copyFileLink, true);) {
            int ch = fis.read();
            while (ch != -1) {
                fos.write((char) ch);
                ch = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
