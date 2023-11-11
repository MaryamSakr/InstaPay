package IstaPay;

public class WalletAcc extends Account{
    @Override
    public boolean verifyAccount(String phone) {
        return false;
    }
}
