/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.io.*;

class Customer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name; //이름
    private String peopleNumber; //주민등록번호
    private String address; //주소
    private String phoneNumber; //전화번호

    Customer(String name, String peopleNumber, String address, String phoneNumber) {
        this.name = name;
        this.peopleNumber = peopleNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    Customer(Customer cust) {
        this.name = cust.getName();
        this.peopleNumber = cust.getPeopleNumber();
        this.address = cust.getAddress();
        this.phoneNumber = cust.getPhoneNumber();
    }

    Customer() {
        this.name = null;
        this.peopleNumber = null;
        this.address = null;
        this.phoneNumber = null;
    }

    public String getName() {
        return name;
    }

    public String getPeopleNumber() {
        return peopleNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeopleNumber(String peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
