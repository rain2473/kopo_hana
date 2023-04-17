package Lesson.day11.file;

public class Exam_file_Main {
    public static void main(String[] args) throws Exception {
        String fileName = "Data.txt";
        String fileDir =
                "C:\\\\Users\\\\admin\\\\Desktop\\\\하금티 광명융기원 교육\\\\JAVA_KOPOXHANA\\\\수업자료\\\\JAVA\\\\";
        String fileLink = fileDir + fileName;
        String copyFileLink = fileDir + "Copyof" + fileName;
        String zipFileLink = fileDir + "ZipOfData.gzip";
        Exam_file_1.copyFile(fileLink, copyFileLink);
        Exam_file_2.zipFile(fileLink, zipFileLink);
        Exam_file_2.checkZipFile(zipFileLink);
    }
}