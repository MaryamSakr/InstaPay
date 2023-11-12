package IstaPay;
import java.util.Map;
public class ToBankAcc implements Transfer{
   // private Customer user;
    @Override
    public void ExecuteTransfer(String accountNum, double amount,Customer user){

        for (Map.Entry<Integer,Customer>found:user.customerMap.entrySet() ){
            //String a=user.getAcc().getAccountNum();
            if(accountNum.equals(found.getValue().getAcc().getAccountNum())){
                Customer receiver =found.getValue();
                receiver.deposit(amount);
                user.withdraw(amount);

            }
        }


    }
}
