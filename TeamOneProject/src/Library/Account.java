/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class Account extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public Long accountNumber;

    /**
     *
     */
    public String accountType;

    /**
     *
     */
    public String description;

    /**
     *
     */
    public BigDecimal balance;

    /**
     *
     */
    public BigDecimal interestRate;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects
     */
    public Account() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
     *
     * @param id
     * @param accountNumber
     * @param accountType
     * @param description
     * @param balance
     * @param interestRate
     */
    public Account(Long id,
            Long accountNumber,
            String accountType,
            String description,
            BigDecimal balance,
            BigDecimal interestRate) {
        super(id);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.description = description;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return accountType + " ACCOUNT " + accountNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.ACCOUNT_NUMBER, accountNumber.toString());
        map.put(DalFields.ACCOUNT_TYPE, accountType);
        map.put(DalFields.DESCRIPTION, description);
        map.put(DalFields.BALANCE, balance.toString());
        if (interestRate != null) {
            map.put(DalFields.INTEREST_RATE, interestRate.toString());
        } else {
            map.put(DalFields.INTEREST_RATE, null);
        }

        return map;
    }

    // </editor-fold>
}
