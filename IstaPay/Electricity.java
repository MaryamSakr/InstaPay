package IstaPay;

public class Electricity implements Bill,Transfer {
String ElectricCompany;
float KWHConsumption;
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
    public double calcAmount(double KWHConsumption)
    {
        double payment;
        payment =KWHConsumption * (0.5);
        System.out.println("you paied " + payment +" L.E to the ElectricCompany " );

        return payment;

    }
}
