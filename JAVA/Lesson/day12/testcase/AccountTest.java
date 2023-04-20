package Lesson.day12.testcase;

import static org.junit.Assert.*;
import org.junit.Test;
import Lesson.day12.unittest.Account;

public class AccountTest {

    @Test
    public void constructor_test() {
        Account account = new Account("홍길동", 30000);
        assertEquals("홍길동", account.getOwner());
        assertEquals(30000, account.getBalance());
    }

    @Test
    public void transfer_test() {
        Account account = new Account("홍길동", 30000);
        Account account2 = new Account("고길동", 0);
        
        account.transfer(account2, 10000);
        
        assertEquals(20000, account.getBalance());
        assertEquals(10000, account2.getBalance());
        
        Account account3 = new Account("김길동", 0);
        account3.transfer(account, 10000);
        
        assertEquals(account3.getBalance(), 0);
        assertEquals(account.getBalance(), 20000);
    }

}
