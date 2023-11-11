package IstaPay;

public class BankAcc extends Account{
    private String BankAPI;
    BankAcc(String API){
        this.setAccountNum(getAccountNum()+1);
        this.BankAPI=API;
    }
    @Override
    public boolean verifyAccount(String phone) {
        return false;
    }

    public String getBankAPI() {
        return BankAPI;
    }

    public void setBankAPI(String bankAPI) {
        BankAPI = bankAPI;
    }
}
