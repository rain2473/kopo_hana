package Lesson.day12.unittest;

public class Main {
    public static void main(String[] args) {
        System.out.println("====테스트 시작====");
        Account account = new Account("홍길동", 30000);
        System.out.println(account);
        
        Account account2 = new Account("고길동", 0);
        account.transfer(account2, Integer.MAX_VALUE + 1);
        // Integer.MAX_VALUE = 2,147,483,648
        
        if (account2.getBalance() != 2147483648l) {
            System.out.println("getBalace() 값 다름 : " + account2.getBalance());
            // -2147183648 => long으로 바꿔야함
        }
        
        System.out.println("====테스트 끝====");
    }
}
