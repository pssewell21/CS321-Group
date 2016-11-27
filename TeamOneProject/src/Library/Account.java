/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Library;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * The object used to describe an Account record.
 * @author Patrick Sewell
 */
public class Account extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     * The account number.
     */
    public Long accountNumber;

    /**
     * The account type.
     */
    public String accountType;

    /**
     * The account description.
     */
    public String description;

    /**
     * The account balance.
     */
    public BigDecimal balance;

    /**
     * The account interest rate.
     */
    public BigDecimal interestRate;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    //TODO: Make the constructors package private so that we can force the 
    //      factories to create these objects like real factories would
    /**
     * This constructor is used for creating new objects.
     */
    public Account() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects.
     *
     * @param id the ID
     * @param accountNumber the account number
     * @param accountType the account type
     * @param description the account description
     * @param balance the account balance
     * @param interestRate the account interestRate
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
