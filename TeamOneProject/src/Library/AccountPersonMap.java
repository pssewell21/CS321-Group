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
public class AccountPersonMap extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public Long accountId;

    /**
     *
     */
    public Long personId;

    private final PersonFactory personFactory;
    private final AccountFactory accountFactory;
    private Person person;
    private Account account;

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
     *
     * @param id
     * @param accountId
     * @param personId
     */
    public AccountPersonMap(Long id,
            Long accountId,
            Long personId) {
        super(id);
        this.accountId = accountId;
        this.personId = personId;

        personFactory = new PersonFactory();
        accountFactory = new AccountFactory();

        person = personFactory.getById(this.personId);
        account = accountFactory.getById(accountId);
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

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.ACCOUNT_ID, accountId.toString());
        map.put(DalFields.PERSON_ID, personId.toString());

        return map;
    }
}
