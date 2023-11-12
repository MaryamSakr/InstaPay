package IstaPay;

import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.HashMap;

import java.util.Map;
public class Customer {
    private String userName;
    private String passWord;
    private String mobileNumber;
    private double balance;
    private Account acc;
    private Transfer transfer;
    public  Map<Integer, Customer> customerMap = new HashMap<>();
    private int id=0;

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
}
