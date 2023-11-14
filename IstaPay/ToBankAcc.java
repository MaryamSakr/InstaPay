package IstaPay;
import java.util.Map;
public class ToBankAcc implements Transfer{
   // private Customer user;
    @Override
    public void ExecuteTransfer(String username, double amount,Customer user){

        if(user.getAcc() instanceof BankAcc) {
            for (Customer found : user.customers) {
                if (username.equals(found.getUserName())) {
                    Customer receiver = found;
                    receiver.deposit(amount);
                    user.withdraw(amount);


                }
            }
        }else {
            System.out.println("you must transfer from BANK ACCOUNT \n");
        }
    }
}
