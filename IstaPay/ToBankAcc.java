package IstaPay;
import java.util.Map;
public class ToBankAcc implements Transfer{
   // private Customer user;
    @Override
    public void ExecuteTransfer(String accountNum, double amount,Customer user){

        if(user.getAcc() instanceof BankAcc) {
            for (Customer found : user.customers) {
                //String a=user.getAcc().getAccountNum();
                if (accountNum.equals(found.getAcc().getAccountNum())) {
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
