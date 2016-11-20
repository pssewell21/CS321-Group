/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.io.*;

class Minusac extends Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long creditLimit; //신용한도

    Minusac(Minusac ma) {
        super(ma);
        this.creditLimit = ma.getcreditLimit();
    }

    Minusac(Account ac, long creditLimit) {
        super(ac);
        this.creditLimit = creditLimit;
    }

    Minusac(long salary, long balance, boolean accountType,
            Customer cust, long creditLimit) {
        super(salary, balance, creditLimit, accountType, cust);
        this.creditLimit = creditLimit;
    }

    Minusac(long salary, long balance, boolean accountType,
            String name, String peopleNumber, String adress, String phoneNumber, long creditLimit) {
        super(salary, balance, creditLimit, accountType, name, peopleNumber, adress, phoneNumber);
        this.creditLimit = creditLimit;
    }

    public long getcreditLimit() {
        return creditLimit;
    }

    public void setcreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }
}
