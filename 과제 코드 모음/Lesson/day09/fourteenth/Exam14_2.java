package Lesson.day09.fourteenth;

public class Exam14_2 {

    public static void main(String[] args) {
        Account account = new Account("4562");
        Account account1 = new Account("4562");
        Account account2 = new Account("45  62");
        Account account3 = new Account("4562  ");
        Account account4 = new Account("4534  ");
        
        System.out.println(account);
        
        System.out.println(account.same(account1));
        System.out.println(account.same(account2));
        System.out.println(account.same(account3));
        System.out.println(account.same(account4));
    }
}
