package IstaPay;

import java.util.Map;

public class ToWallet implements Transfer{
    @Override
    public void ExecuteTransfer(String moblieNumber, double amount,Customer user){
        //Customer receiver = new Customer;

        for (Map.Entry<Integer,Customer>found:user.customerMap.entrySet() ){
            if(moblieNumber.equals(found.getValue().getMobileNumber())){
                Customer receiver =found.getValue();
                receiver.deposit(amount);
                user.withdraw(amount);

            }
        }
    }
}
