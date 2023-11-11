package IstaPay;

public class BankAcc extends Account{
    @Override
    public boolean verifyAccount(String phone) {
        return true;
    }
}
