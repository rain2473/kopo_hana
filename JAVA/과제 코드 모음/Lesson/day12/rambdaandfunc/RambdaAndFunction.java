package Lesson.day12.rambdaandfunc;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class RambdaAndFunction {
    public static void main(String[] args) {
        IntBinaryOperator funcIBO = RambdaAndFunction::add;
        MyFunction funcMy = RambdaAndFunction::duhagi;
        MyFunction rambdaFunc = (int a, int b) -> {
            return a + b;
        };
        MyFunction anomimousCall = new MyFunction() {

            @Override
            public int call(int x, int y) {
                return x + y;
            }
        };

        int result1 = funcIBO.applyAsInt(5, 3);
        int result2 = funcMy.call(5, 3);
        int result3 = rambdaFunc.call(5, 3);
        int result4 = anomimousCall.call(5, 3);
        System.out.println("5 + 3 = " + result1);
        System.out.println("5 + 3 = " + result2);
        System.out.println("5 + 3 = " + result3);
        System.out.println("5 + 3 = " + result4);

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        nums.stream().forEach(num -> System.out.print(num));
        System.out.println();
        nums.stream().forEach(System.out::print);
        System.out.println();
        nums.stream().filter(num -> num % 2 == 0).forEach(System.out::print);
        System.out.println();
        nums.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.print(num / 2));
        System.out.println();
        nums.stream().filter(num -> num % 2 == 0).map(num -> num + "의 몫 : " + num / 2 + "\n")
                .forEach(num -> System.out.print(num));
        System.out.println();
        nums.stream().filter(num -> num % 2 == 0).map(num -> num + "의 몫 : " + num / 2 + "\n")
                .forEach(System.out::print);

        List<String> names = new ArrayList<>();
        names.add("박경덕");
        names.add("박준하");
        names.add("박태현");
        names.add("이동학");

        List<String> parks = getParkList(names);
        System.out.println(parks);

        System.out.println(
                names.stream().filter(name -> name.startsWith("박")).collect(Collectors.toList()));
    }

    public static List<String> getParkList(List<String> names) {
        return names.stream().filter(name -> name.startsWith("박")).collect(Collectors.toList());
        // List<String> results = new ArrayList<>();
        //
        // for (String name : names) {
        // if (name.startsWith("박")) {
        // result.add(name);
        // }
        // }
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int duhagi(int x, int y) {
        return x + y;
    }

    interface MyFunction {
        public abstract int call(int x, int y);
    }
}
