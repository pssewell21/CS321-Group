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

import Common.ExceptionHandler;
import Common.ID;
import Common.Utility;
import DataAccess.DataAccessJavaDb;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The factory used to allow interaction between the library and the database.
 * @author Patrick Sewell
 */
public class AccountTransactionFactory extends LibraryFactoryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private final AccountFactory accountFactory;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the factory object.
     */
    public AccountTransactionFactory() {
        super("APP", "ACCOUNT_TRANSACTION");
        accountFactory = new AccountFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Creates a transaction record for a deposit.
     * @param personId The ID of the person making the deposit
     * @param accountId The ID of the account the deposit is being made in
     * @param amount The amount of the deposit
     */
    public void addDeposit(Long personId, Long accountId, BigDecimal amount) {
        Account account = accountFactory.getById(accountId);

        if (account != null) {
            // TODO: These operations should be done transactionally so if one operation fails, neither is comitted.  Consider for future versions.
            //       Other possibilities chould be making the balance a calculated field so no post-processing is needed in this way.  Custom SQL 
            //       scripts could also be used to make these changes in a single transaction with rollback upon failure if Derby supports it.
            AccountTransaction transaction = new AccountTransaction(ID.newId(), accountId, personId, Utility.getCurrentTime(), amount);
            executeInsert(transaction.toHashMap());

            BigDecimal balance = account.balance.add(amount);

            account.balance = balance;
            accountFactory.executeUpdate(account.toHashMap());
        } else {
            ExceptionHandler.handleException(new Exception("Account not found, deposit failed."));
        }
    }

    /**
     * Creates a transaction record for a withdrawal.
     * @param personId The ID of the person making the withdrawal
     * @param accountId The ID of the account the withdrawal is being made in
     * @param amount The amount of the withdrawal
     */
    public void addWithdrawal(Long personId, Long accountId, BigDecimal amount) {
        Account account = accountFactory.getById(accountId);

        if (account != null) {
            // TODO: These operations should be done transactionally so if one operation fails, neither is comitted.  Consider for future versions.
            //       Other possibilities chould be making the balance a calculated field so no post-processing is needed in this way.  Custom SQL 
            //       scripts could also be used to make these changes in a single transaction with rollback upon failure if Derby supports it.

            // Make amount negative to indicate a withdrawal in the transaction record
            BigDecimal withdrawalAmount = new BigDecimal("0").subtract(amount);

            AccountTransaction transaction = new AccountTransaction(ID.newId(), accountId, personId, Utility.getCurrentTime(), withdrawalAmount);
            executeInsert(transaction.toHashMap());

            // Adding a negative number to the account balance
            BigDecimal balance = account.balance.add(withdrawalAmount);

            account.balance = balance;
            accountFactory.executeUpdate(account.toHashMap());
        } else {
            ExceptionHandler.handleException(new Exception("Account not found, withdrawal failed."));
        }
    }

    /**
     * Gets transaction records for an account in the specified time period.
     * @param accountId The ID of the account to get transactions for
     * @param startTime The start of the period to get transactions fur
     * @param endTime The end of the period to get transactions fur
     * @return
     */
    public List<AccountTransaction> getByAccoundIdAndTimestampRange(Long accountId, Timestamp startTime, Timestamp endTime) {
        List<AccountTransaction> list = new ArrayList<>();

        DataAccessJavaDb.openConnection();

        try {
            String command = generateSelectByAccoundIdAndTimestampRangeCommand(accountId, startTime, endTime);

            if (hasValue(command)) {
                ResultSet resultSet = DataAccessJavaDb.executeSelect(command);
                System.out.println("Select command being executed:\n" + command);

                while (resultSet != null && resultSet.next()) {
                    Long id = resultSet.getLong(DalFields.ID);
                    Long accId = resultSet.getLong(DalFields.ACCOUNT_ID);
                    Long personId = resultSet.getLong(DalFields.PERSON_ID);
                    Timestamp timestamp = resultSet.getTimestamp(DalFields.TRANSACTION_TIMESTAMP);
                    BigDecimal amount = resultSet.getBigDecimal(DalFields.AMOUNT);

                    list.add(new AccountTransaction(id, accId, personId, timestamp, amount));
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

    private String generateSelectByAccoundIdAndTimestampRangeCommand(Long accountId, Timestamp startTime, Timestamp endTime) {
        String command = "SELECT atr.* FROM ACCOUNT a\n"
                + "INNER JOIN ACCOUNT_TRANSACTION atr\n"
                + "    ON atr.ACCOUNT_ID = a.ID\n"
                + "WHERE a.ID = " + accountId.toString() + "\n"
                + "    AND (\n"
                + "        atr.TRANSACTION_TIMESTAMP >= '" + startTime.toString() + "' AND\n"
                + "        atr.TRANSACTION_TIMESTAMP <= '" + endTime.toString() + "'\n"
                + "    )";

        return command;
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
                    Timestamp timestamp = resultSet.getTimestamp(DalFields.TRANSACTION_TIMESTAMP);
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
            //String timestamp = criteria.get(DalFields.TRANSACTION_TIMESTAMP);
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

    @Override
    public String generateInsertCommand(HashMap<String, String> criteria) {
        String command = "";

        if (!criteria.isEmpty()) {
            String accountId = criteria.get(DalFields.ACCOUNT_ID);
            String personId = criteria.get(DalFields.PERSON_ID);
            String timestamp = criteria.get(DalFields.TRANSACTION_TIMESTAMP);
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

    @Override
    public String generateUpdateCommand(HashMap<String, String> criteria) {
        throw new UnsupportedOperationException("Updating account transactions is not supported.");
    }

    // </editor-fold>
}
