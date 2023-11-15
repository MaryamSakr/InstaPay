package IstaPay;

public class Water implements Bill ,Transfer {

    String WaterCompany;
    float WaterConsumption;
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
    public double calcAmount(double WaterConsumption)
    {
        double payment;
        payment =WaterConsumption * (0.1);
        System.out.println("you paied " + payment +" L.E to the water company" );

        return payment;

    }
}
