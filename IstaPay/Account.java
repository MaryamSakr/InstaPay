package IstaPay;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

abstract public class Account {
    public boolean verifyMobileNum(String phone) {
        Pattern pat = Pattern.compile("^01[0-2,5]{1}[0-9]{8}$");
        Matcher mat = pat.matcher(phone);
        Scanner obj = new Scanner(System.in);
        for (int i = 0; i < Customer.customers.size(); i++) {
            Customer acc = Customer.customers.get(i);
            if (phone.equals(acc.getMobileNumber()) ){
                System.out.println("Mobile Number Is already Exist");
                return false;
            }
        }
        String OTP = "171932", OTPverify;
        if (mat.find()) {
            System.out.println("Your OTP is: " + OTP);
            OTPverify = obj.nextLine();
            if (OTP.equals(OTPverify)) {
                return true;
            }else {
                System.out.println("invalid OTP.PLease try again later");
                return false;
            }
        }
        return false;
    }
    abstract public boolean  verifyAccount(String phone);
}
