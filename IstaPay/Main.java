package IstaPay;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        boolean enter = false;
        Customer c1 = new Customer();
        Scanner obj = new Scanner(System.in);
        System.out.println("Hello in our InstaPay application.\n do you want to:\n1-Register\n2-Sign in");
        int opt1 = obj.nextInt();
        if(opt1 == 1){
            System.out.println("Do You want to register as \n1-Bank Account User\n2-Wallet Account User");
            int opt2 = obj.nextInt();
            if(opt2 == 1){
                BankAcc acc1 = new BankAcc();
                System.out.println("Enter Your mobile Number: ");
                String mobil = obj.next();
                if(acc1.verifyMobileNum(mobil)){
                    System.out.println("Enter Your credit card number: ");
                    String creditNum=obj.next();
                    acc1.setCridteNumber(creditNum);
                    if(acc1.verifyAccount(mobil)) {
                        System.out.println("Enter Your userName: ");
                        String user = obj.next();
                        System.out.println("Enter Strong PassWord: ");
                        String pass = obj.next();
                        c1.Register(mobil, user, pass, acc1);
                        enter = true;
                    }
                    else {
                        System.out.println("Invalid credit card.");
                    }
                }


            }else if(opt2 == 2){
                WalletAcc acc2 = new WalletAcc();
                System.out.println("Enter Your mobile Number: ");
                String mobil = obj.next();
                if(acc2.verifyMobileNum(mobil)) {
                    System.out.println("Enter Your provider: ");
                    String provider = obj.next();
                    acc2.setWalletProvider(provider);
                    if(acc2.verifyAccount(mobil)) {
                        System.out.println("Enter Your userName: ");
                        String user = obj.next();
                        System.out.println("Enter Strong PassWord: ");
                        String pass = obj.next();
                        c1.Register(mobil, user, pass, acc2);
                        enter = true;
                    }else {
                        System.out.println("There is no wallet in this number.");
                    }
                }

            }else {
                System.out.println("you enter a wrong option.");
            }
        }else{
            System.out.println("you are in the system");
            enter = true;
        }
        if(enter){
            System.out.println("Do you want To:\n1-Withdraw\n2-Deposit\n3-Transfer\n4-Inquire Your Balance");
            int opt3 = obj.nextInt();
            if(opt3 == 1){
                System.out.println("enter the amount that you want to Withdraw: ");
                double amount = obj.nextDouble();
                c1.withdraw(amount);
            }else if(opt3 == 2){
                System.out.println("enter the amount that you want to Deposit: ");
                double amount = obj.nextDouble();
                c1.deposit(amount);
        }else if(opt3 ==4) {
                System.out.println("Your Balance is: " + c1.getBalance());
            }
    }
    }
}