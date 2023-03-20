package Lesson.day11.file;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        biteArrayWriter();
    }

    public static void textWriter() throws IOException {
        FileWriter fw = new FileWriter(
                "C:\\Users\\admin\\Desktop\\하금티 광명융기원 교육\\JAVA_KOPOXHANA\\수업자료\\JAVA\\DATA.txt",
                true);
        fw.write("Hello world\n");
        fw.flush();
        fw.close();
    }

    public static String textReader() throws IOException {
        StringBuilder result = new StringBuilder("");
        FileReader fr = new FileReader(
                "C:\\Users\\admin\\Desktop\\하금티 광명융기원 교육\\JAVA_KOPOXHANA\\수업자료\\JAVA\\DATA.txt");
        int ch = fr.read();
        while (ch != -1) {
            result.append((char) ch);
            ch = fr.read();
        }
        fr.close();
        return result.toString();
    }

    public static void binaryWriter() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(
                "C:\\\\Users\\\\admin\\\\Desktop\\\\하금티 광명융기원 교육\\\\JAVA_KOPOXHANA\\\\수업자료\\\\JAVA\\\\BINARY.txt",
                true);) {
            fos.write(65);
            fos.write(66);
            fos.flush();
        } catch (IOException e) {
        }
    }
    
    public static void StringReader(String msg) throws IOException{
        Reader reader = new StringReader(msg);
        char ch1 = (char) reader.read();
        char ch2 = (char) reader.read();
        System.out.println(ch1);
        System.out.println(ch2);
    }
    
    public static void biteArrayWriter() throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(65);
        baos.write(66);
        byte[] data = baos.toByteArray();
        System.out.println(data[0]);
        System.out.println(data[1]);
    }
}
