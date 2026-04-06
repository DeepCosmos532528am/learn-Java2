package com.sachin;

import java.sql.*;

public class JDBCPreparedStatement {
    static final private String URL = "jdbc:postgresql://localhost:5432/persondb";
    static final private String USERNAME = "postgres";
    static final private String PASSWORD = "post@MuSiC20042214";


    public static void main(String[] args) {

        //That one part is skipped ForClass.(...) one, because we have already seen this part in the SimpleStatement JDBC version, as it is implicitly managed by the JDBC now after JDBC 4.0+ version. so not an issue to skip here

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

            //Data Retrieval
            String query = "SELECT * FROM EMPLOYEES where emp_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query); //(The Compilation Phase):
//          When you pass the String query (with the ? placeholder) to the connection, the JDBC driver sends this "template" to the database. The database then:
//          Parses the SQL syntax.
//          Checks if the EMPLOYEES table and emp_id column exist.
//                  Pre-compiles an execution plan (deciding whether to use an index or a full table scan).
//                  Stores this plan in the database's "Plan Cache."

            ){
                preparedStatement.setInt(1, 6);//(The Binding Phase):
                //No compilation happens here. The driver simply takes the value 6 and prepares it to be sent to the database. The database engine does not see this value yet.
                ResultSet rs = preparedStatement.executeQuery();//(The Execution Phase):
//          The driver sends only the data (the value 6) to the database. The database looks up the pre-compiled plan it created in step 1, "plugs in" the value 6, and runs it.

                while (rs.next()) {
                    System.out.println("Running retrieval loop");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    System.out.println(fname + " " + lname);
                }
            }

            // Manipulation/Update

//          String uquery = "Update  Employees set salary = ? where emp_id = ?";
//          String uquery = "Insert into Employees (emp_id) values(default)";
//          String uquery = "Delete from Employees where emp_id = ?";
            String uquery = "Alter table Employees Rename column ? to ?"; //For Alter , update like queries the changes are really reflected in the database but despite it returns 0, vecause no any row is added or removed, just the internal structure data is changed
            try (
                    PreparedStatement preparedStatement1 = connection.prepareStatement(uquery);
            ) {

                System.out.println("Hello On line 51");

                //preparedStatement1.setInt(1,100000);
                //preparedStatement1.setInt(2,20);

                //preparedStatement1.setInt(1,21);
                System.out.println("Hello On line 57");

//                preparedStatement1.setString(1,"dept");
//                preparedStatement1.setString(2,"department");
                System.out.println("Hello On line 61");

                int updated = preparedStatement1.executeUpdate();
                System.out.println("Hello On line 64, The last log message");

                if (updated > 0) {
                    System.out.printf("%d Update Successful\n", updated);
                } else {
                    System.out.println("Updated Failed");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
