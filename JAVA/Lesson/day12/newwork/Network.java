package Lesson.day12.newwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Network {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("https://www.google.com");
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            int i = isr.read();
            while (i != -1) {
                System.out.println((char) i);
                i = isr.read();
            }
            isr.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
