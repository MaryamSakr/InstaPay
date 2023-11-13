package IstaPay;

public class BankAcc extends Account{
    private String cridteNumber;
    BankAcc(String cridteNumber){
        this.cridteNumber=cridteNumber;
    }
    BankAcc(){

    }
    @Override
    public boolean verifyAccount(String phone) {
        return true;
    }

    public String getCridteNumber() {
        return cridteNumber;
    }

    public void setCridteNumber(String cridteNumber) {
        this.cridteNumber = cridteNumber;
    }
}
