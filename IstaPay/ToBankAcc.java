package IstaPay;
import java.util.Map;
public class ToBankAcc implements Transfer{
    @Override
    public boolean ExecuteTransfer(String creditNum, double amount){
        for (int i = 0; i < Customer.customers.size(); i++){
            if(Customer.customers.get(i).getAcc() instanceof BankAcc){
                if(creditNum.equals(((BankAcc) Customer.customers.get(i).getAcc()).getCridteNumber())){
                    Customer.customers.get(i).deposit(amount);
                    return true;
                }
            }
        }
        for (Map.Entry<String,String>found:BankAcc.Api.entrySet() ){
            if(creditNum.equals(found.getValue())){
                System.out.println("The process is done");
                return true;
            }
        }
        System.out.println("This credit card number doesn't have an account");
        return false;
    }
}
