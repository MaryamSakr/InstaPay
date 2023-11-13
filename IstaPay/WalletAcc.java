package IstaPay;

import java.util.HashMap;
import java.util.Map;

public class WalletAcc extends Account {
    private String walletProvider;
    WalletAcc(String provider){
        this.walletProvider=provider;
    }
    WalletAcc(){}
    @Override
    public boolean verifyAccount(String phone) {
        for (Map.Entry<String,String>found:this.Providers.entrySet() ){
            if(phone.equals(found.getKey()) && this.getWalletProvider().equals(found.getValue())){
                return true;
            }
        }
        return false;
    }

    public String getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }
    private static Map<String,String> Providers=new HashMap<>();
    static {
        Providers.put("01276012577","orange");
        Providers.put("01554884939","we");
        Providers.put("01159228572","etisalat");
    }
}
