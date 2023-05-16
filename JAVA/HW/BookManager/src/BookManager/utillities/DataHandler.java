package BookManager.utillities;

import java.io.*;
import java.util.*;

import BookManager.domain.table.DataTable;

public class DataHandler {
    private static DataHandler instance;
    private static String fileDir = "/Users/Hong-YoonKi/eclipse-workspace/BookManager/CSV/";

    private DataHandler() {}

    public static DataHandler getInstance() {
        if (instance == null) {
            synchronized (DataHandler.class) {
                if (instance == null) {
                    instance = new DataHandler();
                }
            }
        }
        return instance;
    }

    public static <T> void loadFile(String fileName, DataTable<T> list) throws IOException {
        String fileLink = fileDir + fileName;
        String line = "";
        boolean indexLine = false;
        try (FileInputStream fis = new FileInputStream(fileLink);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
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

    public static <T> void saveFile(String fileName, DataTable<T> list) throws IOException {
        String fileLink = fileDir + fileName;
        try (FileOutputStream fos = new FileOutputStream(fileLink);) {
            fos.write(list.toString().getBytes("UTF-8"));
            for (T obj : list.listUp()) {
                fos.write(obj.toString().getBytes("UTF-8"));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
