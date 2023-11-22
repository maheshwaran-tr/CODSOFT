public class ATM {
    private final UserAccount user = new UserAccount(10000.00);

    public boolean withDraw(double amount) {
        if (amount < user.getAccountBalance()) {
            user.setAccountBalance(user.getAccountBalance() - amount);
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        user.setAccountBalance(user.getAccountBalance() + amount);
    }

    public void checkBalance() {
        System.out.println("YOUR BALANCE IS : " + user.getAccountBalance());
    }
}