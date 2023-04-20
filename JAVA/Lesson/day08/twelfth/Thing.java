package Lesson.day08.twelfth;

public interface Thing {
    double getWeight();

    void setWeight(double weight); // 인터페이스 선언시에도 파라미터 넣어줘야한다. -> 안하면 오버라이딩이 아닌 새로운 메소드 선언이 됨
}
