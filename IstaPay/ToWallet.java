package IstaPay;

import java.sql.Struct;
import java.util.Map;

public class ToWallet implements Transfer{
    @Override
    public boolean ExecuteTransfer(String moblieNumber, double amount){
        for (int i = 0; i < Customer.customers.size(); i++){
            if(Customer.customers.get(i).getAcc() instanceof WalletAcc){
                if(moblieNumber.equals(Customer.customers.get(i).getMobileNumber())){
                    Customer.customers.get(i).deposit(amount);
                    return true;
                }
            }
        }
        for (Map.Entry<String,String>found:WalletAcc.Providers.entrySet() ){
            if(moblieNumber.equals(found.getKey())){
                System.out.println("The process is done");
                return true;
            }
        }
        System.out.println("This mobile number doesn't have a wallet");
        return false;
    }
}
