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
public class Person extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public String name;

    //TODO: Change this to a Date data type
    /**
     *
     */
    public String dateOfBirth;

    /**
     *
     */
    public String address;

    /**
     *
     */
    public String phoneNumber;

    /**
     *
     */
    public String socialSecurityNumber;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects
     */
    public Person() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
     *
     * @param id
     * @param name
     * @param dateOfBirth
     * @param address
     * @param phoneNumber
     * @param socialSecurityNumber
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

    /**
     *
     * @return
     */
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
