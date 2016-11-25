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
public class Account extends LibraryBase  {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    public Long AccountNumber;

    /**
     *
     */
    public String AccountType;
    
    /**
     *
     */
    public String Description;
    
    /**
     *
     */
    public BigDecimal Balance;
    
    /**
     *
     */
    public BigDecimal InterestRate;

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
        AccountNumber = accountNumber;
        AccountType = accountType;
        Description = description;
        Balance = balance;
        InterestRate = interestRate;                  
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return AccountType + " ACCOUNT " + AccountNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.ACCOUNT_NUMBER, AccountNumber.toString());
        map.put(DalFields.ACCOUNT_TYPE, AccountType);
        map.put(DalFields.DESCRIPTION, Description);
        map.put(DalFields.BALANCE, Balance.toString());
        if (InterestRate != null) {
            map.put(DalFields.INTEREST_RATE, InterestRate.toString());
        }
        else {
            map.put(DalFields.INTEREST_RATE, null);
        }

        return map;
    }  
    
    // </editor-fold>
}
