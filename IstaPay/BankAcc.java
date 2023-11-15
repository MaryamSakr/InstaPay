package IstaPay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAcc extends Account{
    private String creditNumber;
    BankAcc(String creditNumber){
        this.creditNumber=creditNumber;
    }
    BankAcc(){
    }
    @Override
    public boolean verifyAccount(String phone) {
        for (Map.Entry<String,String>found:this.Api.entrySet() ){
            if(phone.equals(found.getKey()) && this.creditNumber.equals(found.getValue())){
                return true;
            }
        }
        return false;
    }

    public String getCridteNumber() {
        return creditNumber;
    }

    public void setCridteNumber(String creditNumber) {
        Scanner obj=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            if(creditNumber.length() != 16){
                System.out.println("Invalid credit card number.\nPlease try again:");
                creditNumber=obj.nextLine();
            }
            else {
                this.creditNumber=creditNumber;
                flag=false;
            }
        }
    }
    public static Map<String,String> Api=new HashMap<>();
    static {
        Api.put("01276012577","1234569781253647");
        Api.put("01122143218","2597851635789456");
        Api.put("01064277929","5697843546156348");
    }
}
