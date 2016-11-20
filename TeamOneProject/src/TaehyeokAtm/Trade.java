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
    private long accountNumber; //계좌번호;
    private long tradeDate; //날짜;
    private boolean tradeType; //거래유형;
    private long tradeMoney; //거래액;
    private long balance; //잔고;

    Trade(Trade td) {
        this.accountNumber = td.getAccountNumber();
        this.tradeDate = td.getTradeDate();
        this.balance = td.getBalance();
        this.tradeType = td.getTradeType();
        this.tradeMoney = td.getTradeMoney();
    }

    Trade(long accountNumber, long tradeDate, long balance, boolean tradeType, long tradeMoney) {
        this.accountNumber = accountNumber;
        this.tradeDate = tradeDate;
        this.balance = balance;
        this.tradeType = tradeType;
        this.tradeMoney = tradeMoney;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getTradeDate() {
        return tradeDate;
    }

    public long getBalance() {
        return balance;
    }

    public boolean getTradeType() {
        return tradeType;
    }

    public long getTradeMoney() {
        return tradeMoney;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTradeDate(long tradeDate) {
        this.tradeDate = tradeDate;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setTradeType(boolean tradeType) {
        this.tradeType = tradeType;
    }

    public void setTradeMoney(long tradeMoney) {
        this.tradeMoney = tradeMoney;
    }
}
