/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
