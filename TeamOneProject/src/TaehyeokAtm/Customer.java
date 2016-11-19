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
    private String name;//이름
    private String peoplenumber;//주민등록번호
    private String adress;//주소
    private String phonenumber;//전화번호

    Customer(String name, String peoplenumber, String adress, String phonenumber) {
        this.name = name;
        this.peoplenumber = peoplenumber;
        this.adress = adress;
        this.phonenumber = phonenumber;
    }

    Customer(Customer cust) {
        this.name = cust.getName();
        this.peoplenumber = cust.getPeoplenumber();
        this.adress = cust.getAdress();
        this.phonenumber = cust.getPhonenumber();
    }

    Customer() {
        this.name = null;
        this.peoplenumber = null;
        this.adress = null;
        this.phonenumber = null;
    }

    public String getName() {
        return name;
    }

    public String getPeoplenumber() {
        return peoplenumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeoplenumber(String peoplenumber) {
        this.peoplenumber = peoplenumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
