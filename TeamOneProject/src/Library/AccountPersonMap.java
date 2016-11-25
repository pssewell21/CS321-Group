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
public class AccountPersonMap extends LibraryBase  {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    public Long AccountId;

    /**
     *
     */
    public Long PersonId;
    
    private Person person;
    
    private Account account;
    
    private PersonFactory personFactory;
    
    private AccountFactory accountFactory;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     * This constructor is used for creating new objects
     */
    
    public AccountPersonMap() {
        super();
        personFactory = new PersonFactory();
        accountFactory = new AccountFactory();
    }

    /**
     * This constructor is used for mapping existing objects
     * @param id
     * @param accountId
     * @param personId
     */
    public AccountPersonMap(Long id, 
            Long accountId, 
            Long personId) {
        super(id);
        AccountId = accountId;
        PersonId = personId;
        
        personFactory = new PersonFactory();
        accountFactory = new AccountFactory();
        
        person = personFactory.getById(PersonId);
        account = accountFactory.executeSelectById(accountId);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return account.toString() + ", PERSON: " + person.toString();
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

        return map;
    }
}
