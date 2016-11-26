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
import java.sql.Timestamp;
import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class AccountTransaction extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public Long accountId;

    /**
     *
     */
    public Long personId;

    /**
     *
     */
    public Timestamp timestamp;

    /**
     *
     */
    public BigDecimal amount;

    private final PersonFactory personFactory;
    private String name;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects
     */
    public AccountTransaction() {
        super();

        personFactory = new PersonFactory();
    }

    /**
     * This constructor is used for mapping existing objects
     *
     * @param id
     * @param accountId
     * @param personId
     * @param timestamp
     * @param amount
     */
    public AccountTransaction(Long id,
            Long accountId,
            Long personId,
            Timestamp timestamp,
            BigDecimal amount) {
        super(id);
        this.accountId = accountId;
        this.personId = personId;
        this.timestamp = timestamp;
        this.amount = amount;

        personFactory = new PersonFactory();
        name = personFactory.getById(this.personId).name;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return "DATE: " + timestamp + ", AMOUNT: $" + amount + ", BY: " + name;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.ACCOUNT_ID, accountId.toString());
        map.put(DalFields.PERSON_ID, personId.toString());
        map.put(DalFields.TRANSACTION_TIMESTAMP, timestamp.toString());
        map.put(DalFields.AMOUNT, amount.toString());

        return map;
    }

    // </editor-fold>
}
