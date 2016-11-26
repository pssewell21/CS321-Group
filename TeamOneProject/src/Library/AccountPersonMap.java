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

import java.util.HashMap;

/**
 * The object used to describe an AccountPersonMap record.
 * @author Patrick Sewell
 */
public class AccountPersonMap extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     * The ID of the account for the account person link.
     */
    public Long accountId;

    /**
     * The ID of the person for the account person link.
     */
    public Long personId;

    private final PersonFactory personFactory;
    private final AccountFactory accountFactory;
    private Person person;
    private Account account;

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects.
     */
    public AccountPersonMap() {
        super();
        personFactory = new PersonFactory();
        accountFactory = new AccountFactory();
    }

    /**
     * This constructor is used for mapping existing objects.
     *
     * @param id the ID
     * @param accountId The account ID
     * @param personId The person ID
     */
    public AccountPersonMap(Long id,
            Long accountId,
            Long personId) {
        super(id);
        this.accountId = accountId;
        this.personId = personId;

        personFactory = new PersonFactory();
        accountFactory = new AccountFactory();

        person = personFactory.getById(personId);
        account = accountFactory.getById(accountId);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        if (person == null) {
            person = personFactory.getById(personId);
        }
        
        if (account == null) {
            account = accountFactory.getById(accountId);
        }
        
        return account.toString() + ", PERSON: " + person.toString();
    }


    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.ACCOUNT_ID, accountId.toString());
        map.put(DalFields.PERSON_ID, personId.toString());

        return map;
    }
}
