/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.io.*;

class Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected long accountnumber;
    protected long salary;
    protected long balance;//잔액;
    protected boolean accounttype;//계좌유형;
    protected Customer cust;//고객정보

    Account(long salary2, long balance2, boolean accounttype2, String name, String peoplenumber, String adress, String phonenumber) {
        this.accountnumber = 0;
        this.salary = 0;
        this.balance = 0;
        this.accounttype = true;
        cust = new Customer();
    }

    Account(Account ac) {
        this.accountnumber = ac.getAccountnumber();
        this.salary = ac.getSalary();
        this.balance = ac.getBalance();
        this.accounttype = ac.getAccounttype();
        cust = new Customer(ac.cust);
    }

    Account(long accountnumber, long salary, long balance, boolean accounttype, Customer cust) {
        this.accountnumber = accountnumber;
        this.salary = salary;
        this.balance = balance;
        this.accounttype = accounttype;
        this.cust = new Customer(cust);
    }

    Account(long accountnumber, long salary, long balance, boolean accounttype,
            String name, String peoplenumber, String adress, String phonenumber) {
        this.accountnumber = accountnumber;
        this.salary = salary;
        this.balance = balance;
        this.accounttype = accounttype;
        cust = new Customer(name, peoplenumber, adress, phonenumber);
    }

    public void setAll(long accountnumber, long salary, long balance, boolean accounttype,
            String name, String peoplenumber, String adress, String phonenumber) {
        this.accountnumber = accountnumber;
        this.salary = salary;
        this.balance = balance;
        this.accounttype = accounttype;
        cust.setName(name);
        cust.setPeoplenumber(peoplenumber);
        cust.setAdress(adress);
        cust.setPhonenumber(phonenumber);
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public long getSalary() {
        return salary;
    }

    public long getBalance() {
        return balance;
    }

    public boolean getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(boolean accounttype) {
        this.accounttype = accounttype;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getName() {
        return cust.getName();
    }

    public String getPeoplenumber() {
        return cust.getPeoplenumber();
    }

    public String getAdress() {
        return cust.getAdress();
    }

    public String getPhonenumber() {
        return cust.getPhonenumber();
    }

    public void setName(String name) {
        cust.setName(name);
    }

    public void setPeoplenumber(String peoplenumber) {
        cust.setPeoplenumber(peoplenumber);
    }

    public void setAdress(String adress) {
        cust.setAdress(adress);
    }

    public void setPhonenumber(String phonenumber) {
        cust.setPhonenumber(phonenumber);
    }
}
