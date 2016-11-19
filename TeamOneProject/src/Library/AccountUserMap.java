/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class AccountUserMap extends LibraryBase  {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    public Long AccountId;

    /**
     *
     */
    public Long UserId;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     * This constructor is used for creating new objects
     */
    
    public AccountUserMap() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
     * @param id
     * @param accountId
     * @param userId
     */
    public AccountUserMap(Long id, 
            Long accountId, 
            Long userId) {
        super(id);
        AccountId = accountId;
        UserId = userId;               
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return super.toString() + ", " 
                + DalFields.ACCOUNT_ID + ": " + AccountId + ", "
                + DalFields.USER_ID + ": " + UserId;
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
        map.put(DalFields.USER_ID, UserId.toString());

        return map;
    }
}
