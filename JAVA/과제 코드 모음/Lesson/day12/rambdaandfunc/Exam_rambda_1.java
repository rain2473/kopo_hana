package Lesson.day12.rambdaandfunc;

public class Exam_rambda_1 {
    public static void main(String[] args) {
        Func1 func1 = Exam_rambda_1::isOdd;
        Func2 func2 = Exam_rambda_1::addNamePrefix;

        System.out.println(func1.func1(15));
        System.out.println(func2.func2(true, "홍길동"));
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static String addNamePrefix(boolean male, String name) {
        if (male == true) {
            return "Mr." + name;
        }
        return "Ms." + name;
    }
}
