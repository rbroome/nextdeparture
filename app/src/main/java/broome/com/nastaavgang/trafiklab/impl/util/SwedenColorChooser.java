package broome.com.nastaavgang.trafiklab.impl.util;

import android.broome.com.nastaavgang.R;

/**
 * Created by robin on 19/09/15.
 */
public class SwedenColorChooser {

    public static int getPrimaryColor(String number, String city){
        switch(city){
            case "Göteborg" :
                return getPrimaryColorGbg(number);
            default :
                return getDefaultPrimaryColor();

        }

    }
    public static int getSecondaryColor(String number,String city){
        switch(city){
            case "Göteborg" :
                return getSecondaryColorGbg(number);
            default :
                return getDefaultSecondaryColor();

        }
    }
    public static int getDefaultPrimaryColor(){
        return R.color.front78;
    }
    public static int getDefaultSecondaryColor(){
        return R.color.secundaryBlue;
    }

    public static int getPrimaryColorGbg(String number){
        int n = Integer.valueOf(number);
        switch(n){
            case 6 :
                return R.color.front6;
            case 7 :
                return R.color.front78;
            case 8 :
                return R.color.front78;
            case 10 :
                return R.color.front10;
            default :
                return R.color.front78;
        }
    }
    public static int getSecondaryColorGbg(String number){
        int n = Integer.valueOf(number);
        switch(n){
            case 6 :
                return R.color.back6;
            case 7 :
                return R.color.back7;
            case 8 :
                return R.color.back8;
            case 10 :
                return R.color.back10;
            default :
                return R.color.secundaryBlue;
        }

    }
}
