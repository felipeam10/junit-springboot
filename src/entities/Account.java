package entities;

public class Account { /*Conta*/

    private static double DEPOSIT_FEE_PERCENTAGE = 0.02;
    private Long id;
    private Double balance; /*saldo*/

    public Account(){}

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance; /*saldo*/
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() { /*saldo*/
        return balance;
    }

    public void deposit(double amount) { /*quantia*/
        if (amount > 0) {
            amount -= amount * DEPOSIT_FEE_PERCENTAGE;
            balance += amount;
        }
    }

    public void withdraw(double amount) { /*withdraw = saque*/
        if(amount > balance) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }

    public double fullWithdraw() {  /*withdraw = saque*/
        double aux = balance;
        balance = 0.0;
        return aux;
    }

}
