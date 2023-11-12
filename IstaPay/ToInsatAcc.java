package IstaPay;
import java.util.Map;
public class ToInsatAcc implements Transfer{
    @Override
    public void ExecuteTransfer(String userName, double amount,Customer user){
        for (Map.Entry<Integer,Customer>found:user.customerMap.entrySet() ){
            if(userName.equals(found.getValue().getUserName())){
                Customer receiver =found.getValue();
                receiver.deposit(amount);
                user.withdraw(amount);
            }
        }
    }
}
