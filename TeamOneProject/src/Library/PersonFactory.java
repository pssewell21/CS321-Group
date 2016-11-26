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

import Common.ID;
import DataAccess.DataAccessJavaDb;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The factory used to allow interaction between the library and the database.
 * @author Patrick Sewell
 */
public class PersonFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the factory object.
     */
    public PersonFactory() {
        super("APP", "PERSON");
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     * Gets a Person object by the value ID field.
     * @param id The ID of the Person record to get
     * @return The single Person record or nothing
     */
    public Person getById(long id) {
        HashMap<String, String> criteria = new HashMap<>();

        criteria.put(DalFields.ID, Long.toString(id));

        List<Person> result = executeSelect(criteria);

        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<Person> executeSelect(HashMap<String, String> criteria) {
        List<Person> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    String name = resultSet.getString(DalFields.NAME);
                    String dateOfBirth = resultSet.getString(DalFields.DATE_OF_BIRTH);
                    String address = resultSet.getString(DalFields.ADDRESS);
                    String phoneNumber = resultSet.getString(DalFields.PHONE_NUMBER);
                    String socialSecurityNumber = resultSet.getString(DalFields.SOCIAL_SECURITY_NUMBER);

                    list.add(new Person(id, name, dateOfBirth, address,
                            phoneNumber, socialSecurityNumber));
                }
            } else {
                System.out.println("No select command was run from the provided criteria");
            }

        } catch (Exception e) {
            handleException(e);
        } finally {
            DataAccessJavaDb.closeConnection();
        }

        return list;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Implementation of ISqlGenerator Methods"> 
    @Override
    public String generateSelectCommand(HashMap<String, String> criteria) {
        //TODOL: Update this comment to be accurate
        // Can filter by ID, NAME, or SOCIAL_SECURITY_NUMBER
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String name = criteria.get(DalFields.NAME);
            //String dateOfBirth = criteria.get(DalFields.DATE_OF_BIRTH);
            //String address = criteria.get(DalFields.ADDRESS);
            //String phoneNumber = criteria.get(DalFields.PHONE_NUMBER);
            String socialSecurityNumber = criteria.get(DalFields.SOCIAL_SECURITY_NUMBER);

            if (hasValue(id) || hasValue(name) || hasValue(socialSecurityNumber)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(name)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.NAME + " = " + name + " ";
                    insertAnd = true;
                }

                if (hasValue(socialSecurityNumber)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.SOCIAL_SECURITY_NUMBER + " = '" + socialSecurityNumber + "' ";
                }
            }
        }

        return command;
    }

    @Override
    public String generateInsertCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String name = criteria.get(DalFields.NAME);
            String dateOfBirth = criteria.get(DalFields.DATE_OF_BIRTH);
            String address = criteria.get(DalFields.ADDRESS);
            String phoneNumber = criteria.get(DalFields.PHONE_NUMBER);
            String socialSecurityNumber = criteria.get(DalFields.SOCIAL_SECURITY_NUMBER);

            if (hasValue(name)
                    && hasValue(dateOfBirth)
                    && hasValue(address)
                    && hasValue(socialSecurityNumber)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "'" + name + "', "
                        + "'" + dateOfBirth + "', "
                        + "'" + address + "', ";

                if (hasValue(phoneNumber)) {
                    command += "'" + phoneNumber + "', ";
                } else {
                    command += "NULL, ";
                }

                command += "'" + socialSecurityNumber + "'"
                        + ")";
            } else {
                //TODO: Make the logic for printing this message logic better
                System.out.println("Required field ????? not set.  Insert failed.");
            }
        } else {
            System.out.println("No criteria have been set.  Insert failed.");
        }

        return command;
    }

    @Override
    public String generateUpdateCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {

            String id = criteria.get(DalFields.ID);
            String name = criteria.get(DalFields.NAME);
            String dateOfBirth = criteria.get(DalFields.DATE_OF_BIRTH);
            String address = criteria.get(DalFields.ADDRESS);
            String phoneNumber = criteria.get(DalFields.PHONE_NUMBER);
            String socialSecurityNumber = criteria.get(DalFields.SOCIAL_SECURITY_NUMBER);

            if (hasValue(id)
                    && hasValue(name)
                    && hasValue(dateOfBirth)
                    && hasValue(address)
                    && hasValue(socialSecurityNumber)) {
                command += "UPDATE " + SCHEMA + "." + TABLE_NAME + " SET "
                        + DalFields.NAME + " = '" + name + "', "
                        + DalFields.DATE_OF_BIRTH + " = '" + dateOfBirth + "', "
                        + DalFields.ADDRESS + " = '" + address + "', ";

                if (hasValue(phoneNumber)) {
                    command += DalFields.PHONE_NUMBER + " = '" + phoneNumber + "', ";
                } else {
                    command += DalFields.PHONE_NUMBER + " = NULL, ";
                }

                command += DalFields.SOCIAL_SECURITY_NUMBER + " = '" + socialSecurityNumber + "' ";

                command += "WHERE " + DalFields.ID + " = " + id;
            }
        } else {
            System.out.println("No criteria have been set.  Update failed.");
        }

        return command;
    }

    // </editor-fold>  
}
