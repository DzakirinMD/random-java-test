package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement vs Prepared Statement
 * <pre>
 | Statement                                      |    Prepared Statement                                        |
 |------------------------------------------------|--------------------------------------------------------------|
 | used for DDL statements                        | used for any SQL Query.                                      |
 | Used for CREATE, ALTER, DROP statements        | Used for the queries which are to be executed multiple times |
 | can not pass parameters at runtime             | can pass parameters at runtime.                              |
 |used when SQL query is to be executed only once | used when SQL query is to be executed multiple times.        |
 *</pre>
 */

public class StatementVsPreparedStatement {
    public static void main(String[] args) throws SQLException {

        // connection to DB
        Connection connection = null;

        /*
        It is used for accessing your database. Statement interface cannot accept parameters and useful
         when you are using static SQL statements at runtime.
         */
        //Creating The Statement Object
        Statement sqlStatement = connection.createStatement();
        //Executing The Statement
        sqlStatement.executeUpdate("CREATE TABLE STUDENT(ID NUMBER NOT NULL, NAME VARCHAR)");

        /*
        It is used when you want to use SQL statements many times.
        The PreparedStatement interface accepts input parameters at runtime.
         */

        //Creating the PreparedStatement object
        PreparedStatement sqlPreparedStatement = connection.prepareStatement("update STUDENT set NAME = ? where ID = ?");
        //Setting values to placeholders
        //Assigns "RAM" to first placeholder
        sqlPreparedStatement.setString(1, "New Name");

        //Assigns "512" to second placeholder
        sqlPreparedStatement.setInt(2, 1122);

        //Executing PreparedStatement
        sqlPreparedStatement.executeUpdate();


    }
}
