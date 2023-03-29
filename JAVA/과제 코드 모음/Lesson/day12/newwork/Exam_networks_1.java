package Lesson.day12.newwork;

import java.io.*;
import java.net.*;

public class Exam_networks_1 {
    public static void main(String[] args) throws IOException {
        String fileLink = "https://alimipro.com/favicon.ico";
        String fileName = fileLink.split("/")[fileLink.split("/").length - 1];
        String fileDir =
                "C:\\\\Users\\\\admin\\\\Desktop\\\\하금티 광명융기원 교육\\\\JAVA_KOPOXHANA\\\\수업자료\\\\JAVA\\\\";
        String DownLoadLink = fileDir + fileName;
        DownLoadFile(fileLink, DownLoadLink);
    }

    public static void DownLoadFile(String fileLink, String DownLoadLink) throws IOException {
        try {
            URL url = new URL(fileLink);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            try (FileOutputStream fos = new FileOutputStream(DownLoadLink, true);) {
                int i = isr.read();
                while (i != -1) {
                    fos.write((char) i);
                    i = isr.read();
                }
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


