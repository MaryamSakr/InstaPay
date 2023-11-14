package IstaPay;
import java.util.BitSet;
import java.util.Scanner;
import java.util.regex.Pattern;

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

                            if(c1.Register(mobil, user, pass, acc1)){
                                enter = true;
                                break;
                            }
                        }
                        else {
                            System.out.println("Invalid credit card.");
                        }
                    }


                }else if(opt2 == 2){
                    WalletAcc acc2 = new WalletAcc("etisalat");
                    System.out.println("Enter Your mobile Number: ");
                    String mobil = obj.next();
                    if(acc2.verifyAccount(mobil)) {
                        System.out.println("Enter Your userName: ");
                        String user = obj.next();
                        System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                        String reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[@#$%&*]).{8,}$";
                        String pass = obj.next();
                        while (!Pattern.matches(reg,pass)){
                            System.out.println("Enter Strong PassWord (should include at least one uppercase one lowercase and one special character and the password should be over than 8 character): ");
                            pass = obj.next();
                        }

                        if(c1.Register(mobil, user, pass, acc2)){
                            enter = true;
                            break;
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
            System.out.println("Hello In our system\nDo you want To:\n1-Withdraw\n2-Deposit\n3-Transfer\n4-Inquire Your Balance\n5-Exit");
            int opt3 = obj.nextInt();
            while (opt3!=5){
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

                    System.out.println("Do you want to transfer to:\n1-Bank Account\n2-InstaPay Account\n3-Wallet\n");
                    int tr=obj.nextInt();
                    if(tr==1){
                        System.out.println("Enter the user name: ");
                        String ather= obj.next();
                        System.out.println("Enter the amount: ");
                        int amount= obj.nextInt();

                        ToBankAcc t=new ToBankAcc() ;
                        t.ExecuteTransfer(ather,amount,c1);
                    }else if(tr ==2){
                        System.out.println("Enter the user name: ");
                        String ather= obj.next();
                        System.out.println("Enter the amount: ");
                        int amount= obj.nextInt();

                        ToInsatAcc t=new ToInsatAcc() ;
                        t.ExecuteTransfer(ather,amount,c1);
                    }else if(tr ==3){
                        System.out.println("Enter the mobile Number: ");
                        String ather= obj.next();
                        System.out.println("Enter the amount: ");
                        int amount= obj.nextInt();

                        ToWallet t=new ToWallet() ;
                        t.ExecuteTransfer(ather,amount,c1);
                    }

                }
                
                System.out.println("Do you want To:\n1-Withdraw\n2-Deposit\n3-Transfer\n4-Inquire Your Balance\n5-Exit");
                opt3 = obj.nextInt();
            }
            System.out.println("See You Again.");
        }else{
            System.out.println("See You Again.");
        }
    }
}
