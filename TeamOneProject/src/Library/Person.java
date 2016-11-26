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
 * The object used to describe an Person record.
 * @author Patrick Sewell
 */
public class Person extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     * The name of the person.
     */
    public String name;

    /**
     * The date of birth of the person.
     */
    public String dateOfBirth;

    /**
     * The address of the person.
     */
    public String address;

    /**
     * The phone number of the person.
     */
    public String phoneNumber;

    /**
     * The social security number of the person.
     */
    public String socialSecurityNumber;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects.
     */
    public Person() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects.
     *
     * @param id The ID
     * @param name The name
     * @param dateOfBirth The date of birth
     * @param address The address
     * @param phoneNumber The phone number
     * @param socialSecurityNumber The social security number
     */
    public Person(Long id,
            String name,
            String dateOfBirth,
            String address,
            String phoneNumber,
            String socialSecurityNumber) {
        super(id);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return name;
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.NAME, name);
        map.put(DalFields.DATE_OF_BIRTH, dateOfBirth);
        map.put(DalFields.ADDRESS, address);
        map.put(DalFields.PHONE_NUMBER, phoneNumber);
        map.put(DalFields.SOCIAL_SECURITY_NUMBER, socialSecurityNumber);

        return map;
    }

    // </editor-fold>
}
