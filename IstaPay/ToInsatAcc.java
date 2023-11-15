package IstaPay;
public class ToInsatAcc implements Transfer{
    @Override
    public boolean ExecuteTransfer(String userName, double amount){
        for (int i = 0; i < Customer.customers.size(); i++){
            if(userName.equals(Customer.customers.get(i).getUserName())){
                Customer.customers.get(i).deposit(amount);
                return true;
            }
        }
        System.out.println("This Account Is Not Exist.");
        return false;
    }
}
