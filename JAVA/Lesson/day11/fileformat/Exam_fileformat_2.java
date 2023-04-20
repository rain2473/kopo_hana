package Lesson.day11.fileformat;

import java.io.*;

public class Exam_fileformat_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 인스턴스 선언
        Employee hong = new Employee("홍길동", 41);
        Department chongmu = new Department("chongmubu", hong);
        // 직렬화
        FileOutputStream fos = new FileOutputStream("company.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hong);
        oos.writeObject(chongmu);
        oos.flush();
        oos.close();
        // 확인부
        FileInputStream fis = new FileInputStream("company.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee checkEmployee = (Employee) ois.readObject();
        Department checkDepartment = (Department) ois.readObject();
        ois.close();
        System.out.println(checkEmployee.toString());
        System.out.println(checkDepartment.toString());
    }
}
