/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.io.*;

public class Trade implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long accountnumber;//계좌번호;
    private long tradedate;//날짜;
    private boolean tradetype;//거래유형;
    private long trademoney;//거래액;
    private long balance;//잔고;

    Trade(Trade td) {
        this.accountnumber = td.getAccountnumber();
        this.tradedate = td.getTradedate();
        this.balance = td.getBalance();
        this.tradetype = td.getTradetype();
        this.trademoney = td.getTrademoney();
    }

    Trade(long accountnumber, long tradedate, long balance, boolean tradetype, long trademoney) {
        this.accountnumber = accountnumber;
        this.tradedate = tradedate;
        this.balance = balance;
        this.tradetype = tradetype;
        this.trademoney = trademoney;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public long getTradedate() {
        return tradedate;
    }

    public long getBalance() {
        return balance;
    }

    public boolean getTradetype() {
        return tradetype;
    }

    public long getTrademoney() {
        return trademoney;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setTradedate(long tradedate) {
        this.tradedate = tradedate;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setTradetype(boolean tradetype) {
        this.tradetype = tradetype;
    }

    public void setTrademoney(long trademoney) {
        this.trademoney = trademoney;
    }
}
