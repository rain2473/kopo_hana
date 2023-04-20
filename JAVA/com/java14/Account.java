package com.java14;

import java.util.Objects;
import com.company.Book;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber) {
        this(accountNumber, 0);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        String msg = this.getBalance() + "원 (계좌번호=" + this.getAccountNumber() + "))";
        return msg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return Objects.equals(accountNumber.trim(), other.accountNumber.trim());
    }

    public String same(Account o) {
        String msg = "다릅니다!";
        if (this.equals(o)) {
            msg = "같습니다!";
        }
        return msg;
    }

}
