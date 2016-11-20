/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Common.ID;
import DataAccess.DataAccessJavaDb;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public class AccountTransactionFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private AccountFactory accountFactory;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    public AccountTransactionFactory() {
        super("APP", "ACCOUNT_TRANSACTION");
        accountFactory = new AccountFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param personId
     * @param accountId
     * @param amount
     */
    public void addDeposit(Long personId, Long accountId, BigDecimal amount) {
        Account account = accountFactory.executeSelectById(accountId);

        if (account != null) {
            // TODO: These operations should be done transactionally so if one operation fails, neither is comitted.  Consider for future versions.
            //       Other possibilities chould be making the balance a calculated field so no post-processing is needed in this way.  Custom SQL 
            //       scripts could also be used to make these changes in a single transaction with rollback upon failure if Derby supports it.
            AccountTransaction transaction = new AccountTransaction(ID.newId(), accountId, personId, new Timestamp(System.currentTimeMillis()), amount);
            executeInsert(transaction.toHashMap());
            
            BigDecimal balance = account.Balance.add(amount);

            account.Balance = balance;
            accountFactory.executeUpdate(account.toHashMap());
        }
    }
    
    /**
     *
     * @param personId
     * @param accountId
     * @param amount
     */
    public void addWithdrawal(Long personId, Long accountId, BigDecimal amount) {
        Account account = accountFactory.executeSelectById(accountId);

        if (account != null) {
            // TODO: These operations should be done transactionally so if one operation fails, neither is comitted.  Consider for future versions.
            //       Other possibilities chould be making the balance a calculated field so no post-processing is needed in this way.  Custom SQL 
            //       scripts could also be used to make these changes in a single transaction with rollback upon failure if Derby supports it.
            AccountTransaction transaction = new AccountTransaction(ID.newId(), accountId, personId, new Timestamp(System.currentTimeMillis()), amount);
            executeInsert(transaction.toHashMap());
            
            BigDecimal balance = account.Balance.subtract(amount);

            account.Balance = balance;
            accountFactory.executeUpdate(account.toHashMap());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Implementation of LibraryFactoryBase Methods"> 
    @Override
    public List<AccountTransaction> executeSelect(HashMap<String, String> criteria) {
        List<AccountTransaction> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectCommand(criteria);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long accountId = resultSet.getLong(DalFields.ACCOUNT_ID);
                    Long personId = resultSet.getLong(DalFields.PERSON_ID);
                    Timestamp timestamp = resultSet.getTimestamp(DalFields.TIMESTAMP);
                    BigDecimal amount = resultSet.getBigDecimal(DalFields.AMOUNT);

                    list.add(new AccountTransaction(id, accountId, personId, timestamp, amount));
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
        // Can filter by ID, ACCOUNT_ID, or PERSON_ID
        String command = "SELECT * FROM " + SCHEMA + "." + TABLE_NAME;

        if (criteria != null && !criteria.isEmpty()) {
            String and = "AND ";
            boolean insertAnd = false;

            String id = criteria.get(DalFields.ID);
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);
            //String timestamp = criteria.get(DalFields.TIMESTAMP);
            //String amount = criteria.get(DalFields.AMOUNT);

            if (hasValue(id) || hasValue(accountId) || hasValue(personId)) {
                command += "\nWHERE ";

                if (hasValue(id)) {
                    command += DalFields.ID + " = " + id + " ";
                    insertAnd = true;
                }

                if (hasValue(accountId)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.ACCOUNT_ID + " = " + accountId + " ";
                    insertAnd = true;
                }

                if (hasValue(personId)) {
                    if (insertAnd) {
                        command += and;
                    }

                    command += DalFields.PERSON_ID + " = " + personId + " ";
                }
            }
        }

        return command;
    }

    /**
     *
     * @param criteria
     * @return
     */
    @Override
    public String generateInsertCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);
            String timestamp = criteria.get(DalFields.TIMESTAMP);
            String amount = criteria.get(DalFields.AMOUNT);

            if (hasValue(accountId)
                    && hasValue(personId)
                    && hasValue(timestamp)
                    && hasValue(amount)) {
                command += "INSERT INTO " + SCHEMA + "." + TABLE_NAME + " VALUES ("
                        + ID.newId() + ", "
                        + "" + accountId + ", "
                        + "" + personId + ", "
                        + "'" + timestamp + "', "
                        + "" + amount + ""
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

    /**
     *
     * @param criteria
     * @return
     */
    @Override
    public String generateUpdateCommand(HashMap<String, String> criteria) {
        throw new UnsupportedOperationException("Updating account transactions is not supported.");
    }

    // </editor-fold>
}
