package IstaPay;

public class BankAcc extends Account{
    @Override
    public boolean verifyAccount(String phone) {
        return true;
    }
    private String BankAPI;
    BankAcc(){
        this.setAccountNum(getAccountNum()+1);
    }
    public String getBankAPI() {
        return BankAPI;
    }

    public void setBankAPI(String bankAPI) {
        BankAPI = bankAPI;
    }
}
