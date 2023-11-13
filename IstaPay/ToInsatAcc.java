package IstaPay;
import java.util.Map;
public class ToInsatAcc implements Transfer{
    @Override
    public void ExecuteTransfer(String userName, double amount,Customer user){
        for (Customer found:user.customers ){
            if(userName.equals(found.getUserName())){
                Customer receiver =found;
                receiver.deposit(amount);
                user.withdraw(amount);

            }
        }
    }
}
