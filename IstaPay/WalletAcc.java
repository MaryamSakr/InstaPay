package IstaPay;

public class WalletAcc extends Account {
    private String walletProvider;
    WalletAcc(String provider){
        this.walletProvider=provider;
    }
    @Override
    public boolean verifyAccount(String phone) {
        return true;
    }

    public String getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }
}
