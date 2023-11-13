package IstaPay;

import java.util.Map;

public class ToWallet implements Transfer{
    @Override
    public void ExecuteTransfer(String moblieNumber, double amount,Customer user){
        //Customer receiver = new Customer;

       for (Customer found:user.customers){
            if(moblieNumber.equals(found.getMobileNumber())){
                Customer receiver =found;
                receiver.deposit(amount);
                user.withdraw(amount);

            }
        }
    }
}
