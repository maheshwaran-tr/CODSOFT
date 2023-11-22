public class UserAccount {
    private double accountBalance;

    UserAccount(double initialBalance){
        this.accountBalance = initialBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}