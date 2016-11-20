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
public class Person extends LibraryBase  {
    
    // <editor-fold defaultstate="collapsed" desc="Member Variables">   

    /**
     *
     */
    public String Name;

    //TODO: Change this to a Date data type
    /**
     *
     */
    public String DateOfBirth;
    
    /**
     *
     */
    public String Address;
    
    /**
     *
     */
    public String PhoneNumber;
    
    /**
     *
     */
    public String SocialSecurityNumber;

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
        Name = name;
        DateOfBirth = dateOfBirth;
        Address = address;
        PhoneNumber = phoneNumber;
        SocialSecurityNumber = socialSecurityNumber;                  
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    @Override
    public String toString() {
        return super.toString() + ", " 
                + DalFields.NAME + ": " + Name + ", "
                + DalFields.DATE_OF_BIRTH + ": " + DateOfBirth + ", "
                + DalFields.ADDRESS + ": " + Address + ", "
                + DalFields.PHONE_NUMBER + ": " + PhoneNumber + ", "
                + DalFields.SOCIAL_SECURITY_NUMBER + ": " + SocialSecurityNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.NAME, Name);
        map.put(DalFields.DATE_OF_BIRTH, DateOfBirth);
        map.put(DalFields.ADDRESS, Address);
        map.put(DalFields.PHONE_NUMBER, PhoneNumber);
        map.put(DalFields.SOCIAL_SECURITY_NUMBER, SocialSecurityNumber);

        return map;
    }
    
    // </editor-fold>
}
