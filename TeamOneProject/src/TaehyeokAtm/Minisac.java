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
    private long creditlimit;//신용한도

    Minusac(Minusac ma) {
        super(ma);
        this.creditlimit = ma.getcreditlimit();
    }

    Minusac(Account ac, long creditlimit) {
        super(ac);
        this.creditlimit = creditlimit;
    }

    Minusac(long salary, long balance, boolean accounttype,
            Customer cust, long creditlimit) {
        super(salary, balance, creditlimit, accounttype, cust);
        this.creditlimit = creditlimit;
    }

    Minusac(long salary, long balance, boolean accounttype,
            String name, String peoplenumber, String adress, String phonenumber, long creditlimit) {
        super(salary, balance, creditlimit, accounttype, name, peoplenumber, adress, phonenumber);
        this.creditlimit = creditlimit;
    }

    public long getcreditlimit() {
        return creditlimit;
    }

    public void setcreditlimit(long creditlimit) {
        this.creditlimit = creditlimit;
    }
}
