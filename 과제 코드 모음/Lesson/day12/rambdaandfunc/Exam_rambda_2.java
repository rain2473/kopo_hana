package Lesson.day12.rambdaandfunc;

public class Exam_rambda_2 {
    public static void main(String[] args) {
        Func1 func1 = (int n) -> {
            return n % 2 == 1;
        };

        Func2 func2 = (boolean male, String name) -> {
            if (male == true) {
                return "Mr." + name;
            }
            return "Ms." + name;
        };

        System.out.println(func1.func1(15));
        System.out.println(func2.func2(true, "홍길동"));
    }
}
