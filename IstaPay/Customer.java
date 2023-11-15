package IstaPay;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

import java.util.Map;
import java.util.Vector;

public class Customer {
    private String userName;
    private String passWord;
    private String mobileNumber;
    private double balance = 1000;
    private Account acc;
    private Transfer transfer;
    public  Map<Integer, Customer> customerMap = new HashMap<>();
    private int id = 0;
    Customer(String userName,String mobileNumber,String passWord,Account account){
        this.userName=userName;
        this.mobileNumber=mobileNumber;
        this.passWord=passWord;
        this.acc=account;
    }
    Customer(){

    }
    public void withdraw(double amount){
        if (amount> balance){
            System.out.println("the amount exceed your balance.");
        }else {
            balance-=amount;
            System.out.println("Your balance is "+balance);
        }
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Your balance is " + balance);
    }
    public void TransferExecution(Transfer t){
        transfer = t;
    }

    public boolean Register(String userName , String passWord , String mobileNumber , Account account){
            for (int i = 0; i < customers.size(); i++) {
                Customer acc = customers.get(i);
                if (acc.userName.equals(userName) ){
                    System.out.println("userName Is already Exist");
                    return false;
                }
            }
            this.userName = userName;
            this.passWord = passWord;
            this.mobileNumber = mobileNumber;
            this.acc = account;
            this.balance = 1000;
            id=customerMap.size()+1;
            customerMap.put(id,this);
            Customer c=new Customer(userName,passWord,mobileNumber,account);
            customers.add(c);
            return true;

    }
    public boolean signIn(String user , String pass){
        for (int i = 0; i < customers.size(); i++) {
            Customer account = customers.get(i);
            if (account.userName.equals(user) && account.passWord.equals(pass)){
                return true;
            }
        }
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Account getAcc() {
        return acc;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }
    public static Vector<Customer> customers= new Vector<Customer>();
    static {
        Account acc=new BankAcc("1234569781253647");
        Customer c=new Customer("alaa","01276012577","01276012577*Al",acc);
        customers.add(c);
        Account acc2=new BankAcc("2597851635789456");
        Customer c2=new Customer("maryam","01122143218","Moka&2002",acc2);
        customers.add(c2);
        Account acc3=new WalletAcc("we");
        Customer c3=new Customer("asmaa","01554884939","AsmaaSaleh/312",acc3);
        customers.add(c3);
        Account acc4=new BankAcc("etisalat");
        Customer c4=new Customer("salma","01159228572","SalmaMorad$123",acc4);
        customers.add(c4);

        //adding companies accounts :

        Account acc5=new BankAcc("1000");
        Customer c5=new Customer("gas","01100000000","gass1010",acc);
        customers.add(c5);

        Account acc6=new BankAcc("1001");
        Customer c6=new Customer("water","01100000001","water1010",acc);
        customers.add(c6);

        Account acc7=new BankAcc("1002");
        Customer c7=new Customer("electricity","01100000002","electricity1010",acc3);
        customers.add(c7);


    }


}
