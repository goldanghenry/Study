public class Account {
    private double balance; // 잔고, instance variable that store the balance

    public Account (double initialBalance){ // 생성자 초기화
        if (initialBalance > 0.0 ) balance = initialBalance;
    }

    public void credit (double amount) {    // 입금
        balance=balance + amount;
    }
    public double getBalance() {
        return balance;
    }
}

