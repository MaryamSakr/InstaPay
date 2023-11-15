package IstaPay;

public class Water implements Bill ,Transfer {
    float WaterConsumption=1000;
    public boolean ExecuteTransfer(String companyName , double toPay) {
        for (int i = 0; i < Customer.customers.size(); i++){
            Customer found = Customer.customers.get(i);
            if(companyName.equals(found.getUserName())){
                Customer receiverCompany =found;
                receiverCompany.deposit(toPay);
                return true;
            }
        }
        return false;

    }
    public double calcAmount() {
        double payment;
        payment =this.WaterConsumption * (0.1);
        System.out.println("you paied " + payment +" L.E to the water company" );
        return payment;
    }
    public void setWaterConsumption(float waterConsumption) {
        WaterConsumption = waterConsumption;
    }
}
