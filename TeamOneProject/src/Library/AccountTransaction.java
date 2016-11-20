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
public class AccountTransaction extends LibraryBase  {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    public Long AccountId;

    /**
     *
     */
    public Long PersonId;
    
    /**
     *
     */
    public Timestamp Timestamp;
    
    /**
     *
     */
    public BigDecimal Amount;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     * This constructor is used for creating new objects
     */
    
    public AccountTransaction() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
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
        AccountId = accountId;
        PersonId = personId;
        Timestamp = timestamp;
        Amount = amount;                  
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return super.toString() + ", " 
                + DalFields.ACCOUNT_ID + ": " + AccountId + ", "
                + DalFields.PERSON_ID + ": " + PersonId + ", "
                + DalFields.TRANSACTION_TIMESTAMP + ": " + Timestamp + ", "
                + DalFields.AMOUNT + ": " + Amount;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.ACCOUNT_ID, AccountId.toString());
        map.put(DalFields.PERSON_ID, PersonId.toString());
        map.put(DalFields.TRANSACTION_TIMESTAMP, Timestamp.toString());
        map.put(DalFields.AMOUNT, Amount.toString());

        return map;
    }  
    
    // </editor-fold>
}
