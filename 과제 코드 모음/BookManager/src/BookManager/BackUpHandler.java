package BookManager;

import java.io.*;
import java.util.*;

public class BackUpHandler {
    private static BackUpHandler instance;
    private static String fileDir = "C:\\Users\\admin\\eclipse-workspace\\BookManager\\CSV\\";

    private BackUpHandler() {}

    public static BackUpHandler getInstance() {
        if (instance == null) {
            synchronized (InputHandler.class) {
                if (instance == null) {
                    instance = new BackUpHandler();
                }
            }
        }
        return instance;
    }

    public static <T> void loadFile(String fileName, Listable<T> list) throws IOException {
        String fileLink = fileDir + fileName;
        String line = "";
        boolean indexLine = false;
        try (FileInputStream fis = new FileInputStream(fileLink);
                InputStreamReader isr = new InputStreamReader(fis, "CP949");
                BufferedReader br = new BufferedReader(isr)) {
            while ((line = br.readLine()) != null) {
                if (indexLine) {
                    List<String> informations = Arrays.asList(line.split(","));
                    list.loadFromBackup(informations);
                } else {
                    indexLine = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> void saveFile(String fileName, Listable<T> list) throws IOException {
        String fileLink = fileDir + fileName;
        try (FileOutputStream fos = new FileOutputStream(fileLink);) {
            fos.write(list.toString().getBytes("CP949"));
            for (T obj : list.listUp()) {
                fos.write(obj.toString().getBytes("CP949"));
            }
            System.out.println("파일이 저장되었습니다. 프로젝트를 새로고침(F5)하세요.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
