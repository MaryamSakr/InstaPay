package IstaPay;

public class Gas implements Bill ,Transfer {
    float gasConsumption=500;
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
        payment =this.gasConsumption * (0.3);
        System.out.println("you paied " + payment +" L.E to the gas company" );
        return payment;
    }
    public void setGasConsumption(float gasConsumption) {
        this.gasConsumption = gasConsumption;
    }
}
