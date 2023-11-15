package IstaPay;
//import java.lang.String;

public class Gas implements Bill ,Transfer {
    String gasSupplier;
    float gasConsumption;
    public void ExecuteTransfer(String companyName , double consumption , Customer user)
    {
        double toPay = calcAmount(consumption);

        for (Customer found:user.customers){
            if(companyName.equals(found.getUserName())){
                Customer receiverCompany =found;
                receiverCompany.deposit(toPay);
                user.withdraw(toPay);
            }
        }
    }
    public double calcAmount(double gasConsumption)
    {
        double payment;
        payment =gasConsumption * (0.3);
        System.out.println("you paied " + payment +" L.E to the gas company" );

        return payment;
    }
}
