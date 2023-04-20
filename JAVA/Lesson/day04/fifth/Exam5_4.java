package Lesson.day04.fifth;

public class Exam5_4 {
    public static double calcTriangleArea(double bottom, double height) {
        double area = bottom * height / 2;
        return area;
    }

    public static double calcCircleArea(double radius) {
        double area = Math.pow(radius, 2) * Math.PI;
        return area;
    }

    public static void printArea(String figure, double area) {
        System.out.println(figure + "의 넓이는 : " + area + "cm^2");
    }

    public static void main(String[] args) {
        printArea("삼각형", calcTriangleArea(15.5, 4));
        printArea("원", calcCircleArea(3));
    }
}