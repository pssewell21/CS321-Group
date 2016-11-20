/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.awt.Dimension;
import java.util.*;

public class ATM {

    Trade td[];
    private ATMUI atmui;

    public void showdetails(Trade td) {
        String type;
        if (td.getTradeType()) {
            type = "Deposit";
        } else {
            type = "Withdrawal";
        }
        String details = "Date: ";
        long times = td.getTradeDate();
        Date dt = new Date();
        dt.setTime(times);
        details = details.concat(dt.toString());
        details = details.concat("Amount: ");
        details = details.concat(String.valueOf(td.getBalance()));
        details = details.concat(type);
        details = details.concat("Transaction amount: ");
        details = details.concat(String.valueOf(td.getTradeMoney()));
        System.out.println(details);
    }

    public void uirun() {
        try {
            atmui = new ATMUI();
            atmui.setVisible(true);
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        ATM atm = new ATM();
//        //atm.testrun();
//        atm.uirun();
//    }
}
