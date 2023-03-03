package dontdo;

import java.util.stream.IntStream;

public class LockOnValueBased {

  public static void main(String[] args) {
    var account = new BankAccount(1000);
    IntStream.range(0,1_000_000)
        .parallel()
        .forEach(i -> {
          account.deposit(100);
          account.withdraw(100);
        });
    System.out.println(account.getBalance());
  }
}

class BankAccount {

  private Double balance;

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
    synchronized (balance) { // should never be locked like this!! it may change during time
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    deposit(-amount);
  }

  public Double getBalance() {
    synchronized (balance) {
      return balance;
    }
  }
}