package Lesson.day12.unittest;

public class Account {
    private String owner;
    private int balance;
    
    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // 1원부터 1억까지 송금 가능 => 해당 범위를 커버하는 범위
    // test 케이스 : 0, 1, 1억 1억1원 2, 9999만 9999
    public void transfer(Account dest, int amount) {
        dest.setBalance(dest.getBalance() + amount);
        balance -= amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getOwner() {
        return this.owner;
    }

}
