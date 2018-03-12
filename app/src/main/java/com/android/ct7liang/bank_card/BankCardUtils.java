package com.android.ct7liang.bank_card;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-03-12.
 */

public class BankCardUtils {

    public static boolean isTrue(String cardNum){
        String string = new StringBuilder(cardNum).reverse().toString();
        ArrayList<Integer> J = new ArrayList<>();
        ArrayList<Integer> O = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (i%2==0){
                J.add(Integer.parseInt(string.charAt(i)+""));
            }else{
                int i1 = Integer.parseInt(string.charAt(i) + "");
                int i2 = i1 * 2;
                if (i2>=10){
                    i2 = i2-9;
                }
                O.add(i2);
            }
        }
        int a = 0;
        for (int i = 0; i < J.size(); i++) {
            a += J.get(i);
        }
        int b = 0;
        for (int i = 0; i < O.size(); i++) {
            b += O.get(i);
        }
        if ((a+b)%10==0){
            return true;
        }else{
            return false;
        }
    }
}
