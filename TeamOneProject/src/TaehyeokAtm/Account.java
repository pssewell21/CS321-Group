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
    protected long accountNumber;
    protected long salary;
    protected long balance; //잔액;
    protected boolean accountType; //계좌유형;
    protected Customer customer; //고객정보

    Account(long salary2, long balance2, boolean accountType2, String name, String peopleNumber, String address, String phoneNumber) {
        this.accountNumber = 0;
        this.salary = 0;
        this.balance = 0;
        this.accountType = true;
        customer = new Customer();
    }

    Account(Account ac) {
        this.accountNumber = ac.getAccountNumber();
        this.salary = ac.getSalary();
        this.balance = ac.getBalance();
        this.accountType = ac.getAccountType();
        customer = new Customer(ac.customer);
    }

    Account(long accountNumber, long salary, long balance, boolean accountType, Customer customer) {
        this.accountNumber = accountNumber;
        this.salary = salary;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = new Customer(customer);
    }

    Account(long accountNumber, long salary, long balance, boolean accountType,
            String name, String peopleNumber, String address, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.salary = salary;
        this.balance = balance;
        this.accountType = accountType;
        customer = new Customer(name, peopleNumber, address, phoneNumber);
    }

    public void setAll(long accountNumber, long salary, long balance, boolean accountType,
            String name, String peopleNumber, String address, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.salary = salary;
        this.balance = balance;
        this.accountType = accountType;
        customer.setName(name);
        customer.setPeopleNumber(peopleNumber);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getSalary() {
        return salary;
    }

    public long getBalance() {
        return balance;
    }

    public boolean getAccountType() {
        return accountType;
    }

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getName() {
        return customer.getName();
    }

    public String getPeopleNumber() {
        return customer.getPeopleNumber();
    }

    public String getAddress() {
        return customer.getAddress();
    }

    public String getPhoneNumber() {
        return customer.getPhoneNumber();
    }

    public void setName(String name) {
        customer.setName(name);
    }

    public void setPeopleNumber(String peopleNumber) {
        customer.setPeopleNumber(peopleNumber);
    }

    public void setAdress(String adress) {
        customer.setAddress(adress);
    }

    public void setPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
    }
}
