package IstaPay;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

abstract public class Account {
    protected static String accountNum;
    Account(){
        this.accountNum=getAccountNum()+1;
    }

    public boolean verifyMobileNum(String phone) {
        Pattern pat = Pattern.compile("^\\d{11}$");
        Matcher mat = pat.matcher(phone);
        Scanner obj = new Scanner(System.in);
        String OTP = "171932", OTPverify;
        if (mat.find()) {
            System.out.println("Your OTP is: " + OTP);
            OTPverify = obj.nextLine();
            if (OTP.equals(OTPverify)) {
                return true;
            }else {
                System.out.println("Unvalid OTP.PLease try again later");
                return false;
            }
        }
        return false;
    }
    abstract public boolean verifyAccount(String phone);

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }
}
