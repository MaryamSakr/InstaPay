package IstaPay;
import java.util.Scanner;
import java.util.regex.Pattern;

//when sign in function you must use the accounts that exists on customers vector at customer class.
//when register as bank account user you must use the phone number and credit card number those exist on the API Map
// that exists on BankAcc.
//when register as Wallet account user you must use the phone number and Provider company name those exist on the Providers Map
// that exists on WalletAcc.
public class Main {
    public static void main(String[]args){
        boolean enter = false;
        Customer c1 = new Customer();
        Scanner obj = new Scanner(System.in);
        System.out.println("Hello in our InstaPay application.\n do you want to:\n1-Register\n2-Sign in\n3-Exit");
        int opt1 = obj.nextInt();
        while (opt1!=3){
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
                            System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                            String reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$%&*]).{8,}$";
                            String pass = obj.next();
                            while (!Pattern.matches(reg,pass)){
                                System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                                pass = obj.next();
                            }
                            if(c1.Register(user, pass, mobil,acc1)){
                                enter = true;
                                break;
                            }
                        }
                        else {
                            System.out.println("Bank Account not exist");
                        }
                    }


                }else if(opt2 == 2){
                    WalletAcc acc2 = new WalletAcc();
                    System.out.println("Enter Your mobile Number: ");
                    String mobil = obj.next();
                    if(acc2.verifyMobileNum(mobil)) {
                        if(mobil.charAt(2)=='0'){
                            acc2.setWalletProvider("vodafone");
                        }else if(mobil.charAt(2)=='1'){
                            acc2.setWalletProvider("etisalat");
                        }else if(mobil.charAt(2)=='2'){
                            acc2.setWalletProvider("orange");
                        }else if(mobil.charAt(2)=='5'){
                            acc2.setWalletProvider("we");
                        }
                        System.out.println(acc2.getWalletProvider());
                        if (acc2.verifyAccount(mobil)) {
                            System.out.println("Enter Your userName: ");
                            String user = obj.next();
                            System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                            String reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$%&*]).{8,}$";
                            String pass = obj.next();
                            while (!Pattern.matches(reg, pass)) {
                                System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                                pass = obj.next();
                            }
                            if (c1.Register(user, pass, mobil,acc2)) {
                                enter = true;
                                break;
                            }
                        }
                        else {
                            System.out.println("Wallet not exist");
                        }
                    }
                }else {
                    System.out.println("you enter a wrong option.");
                }
            }else if(opt1==2){
                System.out.println("Enter Your UserName: ");
                String user = obj.next();
                System.out.println("Enter Your passWord: ");
                String pass = obj.next();
                if(c1.signIn(user , pass)){
                    enter = true;
                    break;
                }else{
                    System.out.println("The account is not exit.");
                }
            }
            System.out.println("do you want to:\n1-Register\n2-Sign in\n3-Exit");
            opt1 = obj.nextInt();
        }
        if(enter){
            System.out.println("Hello In our system\nDo you want To:\n1-Withdraw\n2-Deposit\n3-Transfer\n4-Inquire Your Balance\n5-pay your bill\n6-Exit");
            int opt3 = obj.nextInt();
            while (opt3!=6){
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

                }else if(opt3==3) {
                    System.out.println("Do you want to transfer to:\n1-Bank Account\n2-InstaPay Account\n3-Wallet\n4-Exit");
                    int trans=obj.nextInt();
                    Transfer t;
                    double amount;
                    switch (trans){
                        case 1:
                            System.out.println("Enter the credit card you want transfer to: ");
                            String creditnum=obj.next();
                            System.out.println("Enter the amount you to transfer: ");
                            amount=obj.nextDouble();
                            t=new ToBankAcc();
                            c1.TransferExecution(t,amount,creditnum);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 2:
                            System.out.println("Enter the user name you want transfer to: ");
                            String username=obj.next();
                            System.out.println("Enter the amount you to transfer: ");
                            amount=obj.nextDouble();
                            t=new ToInsatAcc();
                            c1.TransferExecution(t,amount,username);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 3:
                            System.out.println("Enter the mobile number you want transfer to: ");
                            String phone=obj.next();
                            System.out.println("Enter the amount you to transfer: ");
                            amount=obj.nextDouble();
                            t=new ToWallet();
                            c1.TransferExecution(t,amount,phone);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 4:
                            System.out.println("See You Again.");
                            System.exit(0);
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
                }
                else if(opt3==5) {
                    System.out.println("Do you want to transfer to:\n1-pay gas\n2-pay water\n3-pay electricity\n4-Exit");
                    int trans=obj.nextInt();
                    Transfer t;
                    String userName;
                    double amount=0;
                    switch (trans){
                        case 1:
                            userName="gas";
                            t=new Gas();
                            if(t instanceof Gas) {
                                amount = ((Gas) t).calcAmount();
                            }
                            c1.TransferExecution(t,amount,userName);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 2:
                            userName="water";
                            t=new Water();
                            if(t instanceof Water) {
                                amount = ((Water) t).calcAmount();
                            }
                            c1.TransferExecution(t,amount,userName);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 3:
                            userName="electricity";
                            t=new Electricity();
                            if(t instanceof Electricity) {
                                amount = ((Electricity) t).calcAmount();
                            }
                            c1.TransferExecution(t,amount,userName);
                            System.out.println("Your balance is "+c1.getBalance());
                            break;
                        case 4:
                            System.out.println("See You Again.");
                            System.exit(0);
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
                }
                System.out.println("Do you want To:\n1-Withdraw\n2-Deposit\n3-Transfer\n4-Inquire Your Balance\n5-pay your bill\n6-Exit");
                opt3 = obj.nextInt();
            }
            System.out.println("See You Again.");
            System.exit(0);
        }else{
            System.out.println("See You Again.");
            System.exit(0);
        }
    }



}

