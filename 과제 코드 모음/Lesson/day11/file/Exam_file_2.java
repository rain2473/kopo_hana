package Lesson.day11.file;

import java.io.*;
import java.util.zip.*;

public class Exam_file_2 {
    public static void zipFile(String fileLink, String zipFileLink) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileLink);
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream(zipFileLink);
                GZIPOutputStream gzipOut = new GZIPOutputStream(fos);
                BufferedOutputStream bos = new BufferedOutputStream(gzipOut)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkZipFile(String zipFileLink) throws IOException {
        FileInputStream fis = new FileInputStream(zipFileLink);
        BufferedInputStream bis = new BufferedInputStream(fis);
        GZIPInputStream gzipIn = new GZIPInputStream(bis);
        int size = 0;
        byte[] buffer = new byte[1024];
        while ((size = gzipIn.read(buffer)) > 0) {
            for (int i = 0; i < size; i++) {
                System.out.print((char) buffer[i]);
            }
        }
    }
}
