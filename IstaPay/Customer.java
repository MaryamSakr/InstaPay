package IstaPay;

import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.HashMap;

import java.util.Map;
import java.util.Vector;

public class Customer {
    private String userName;
    private String passWord;
    private String mobileNumber;
    private double balance;
    private Account acc;
    private Transfer transfer;
    public  Map<Integer, Customer> customerMap = new HashMap<>();
    private int id=0;
    Customer(String userName,String mobileNumber,String passWord,Account account){
        this.userName=userName;
        this.mobileNumber=mobileNumber;
        this.passWord=passWord;
        this.acc=account;
        this.balance=1000;
    }
    Customer(){

    }
    public void withdraw(double amount){
        balance-=amount;
        System.out.println(balance);
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println(balance);
    }
    public void TransferExecution(Transfer t){
        transfer = t;
    }

    public void Register(String userName , String passWord , String mobileNumber , Account account){
        Random random = new Random();
        if(account.verifyAccount(mobileNumber)){
            System.out.println("..");
            this.userName = userName;
            this.passWord = passWord;
            this.mobileNumber = mobileNumber;
            this.acc = account;
            this.balance = 1000;
            id=customerMap.size()+1;
            customerMap.put(id,this);
            Customer c=new Customer(userName,passWord,mobileNumber,account);
            customers.add(c);
        }
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
        Account acc2=new BankAcc("25978516357894568");
        Customer c2=new Customer("maryam","01122143218","Moka&2002",acc2);
        customers.add(c2);
        Account acc3=new WalletAcc("we");
        Customer c3=new Customer("asmaa","01554884939","AsmaaSaleh/312",acc3);
        customers.add(c3);
        Account acc4=new BankAcc("etisalat");
        Customer c4=new Customer("salma","01159228572","SalmaMorad$123",acc4);
        customers.add(c4);
    }
}
