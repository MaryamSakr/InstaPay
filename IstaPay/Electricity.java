package IstaPay;

public class Electricity implements Bill,Transfer {
float KWHConsumption=2000;
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
        payment = this.KWHConsumption * (0.5);
        System.out.println("you paied " + payment +" L.E to the ElectricCompany " );
        return payment;
    }

    public void setKWHConsumption(float KWHConsumption) {
        this.KWHConsumption = KWHConsumption;
    }
}
