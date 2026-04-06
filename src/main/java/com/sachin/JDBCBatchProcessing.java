package com.sachin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCBatchProcessing {

    public static void main(String[] args) {
        // INTERVIEW TIP: Try-with-resources (Java 7+) ensures AutoCloseable resources
        // like Connection/Statement are closed even if an exception occurs, preventing memory leaks.
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "post@MuSiC20042214")
        ) {
//            String query = "Create table JDBCTable (id integer Primary Key Generated always as Identity," +
//                    " name varchar(50) not null , salary integer)";
            String query = "Insert into jdbctable (name, salary) values(?, ?)";

            // INTERVIEW TIP: PreparedStatement is pre-compiled by the DB, making it faster
            // for repeated execution and immune to SQL Injection attacks.
            try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                 Scanner sc = new Scanner(System.in);
            ) {
                while (true) {

                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Salary");
                    int salary = sc.nextInt();

                    // INTERVIEW TIP: Positional parameters (?) use 1-based indexing, not 0-based.
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, salary);

                    // INTERVIEW TIP: addBatch() stores the command in a local list instead of
                    // sending it to the DB immediately. This reduces network round-trips.
                    preparedStatement.addBatch();

                    System.out.println("Want to add more data?");
                    String toProceed = sc.next();
                    if (toProceed.equals("no")) {
                        break;
                    }

                }
                // INTERVIEW TIP: executeBatch() sends the entire list of commands to the
                // DB in one single network call. It returns an int array where each
                // element represents the update count for that specific command.
                int[] update = preparedStatement.executeBatch();
                for (int updates : update){
                    System.out.println(updates);
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
* 🧠 Deep Dive: Interview "Must-Knows"If an interviewer asks you about Batch Processing, here is the "Deep Knowledge" they are looking for:1.
*  Why use Batch Processing?The Problem: Without batching, inserting 1,000 rows means 1,000 separate network requests.
*  This creates huge latency (network overhead).The Solution: Batching groups these into one request.
* It significantly improves performance and reduces the load on the database server.2. Statement vs.
*  PreparedStatement in BatchesYou used PreparedStatement.
*  This is preferred because the SQL query is compiled once, and only the data changes in the batch.
* If you used a plain Statement, the DB would have to re-parse the SQL for every single entry in the batch, which is much slower.3.
*  What does executeBatch() return?It returns an int[].
* Each integer in the array tells you what happened to that specific row:Value $\ge 0$: The row was processed successfully (number of rows affected).
* SUCCESS_NO_INFO (-2): The command was successful, but the number of rows affected is unknown.EXECUTE_FAILED (-3): The command failed (though usually, a BatchUpdateException is thrown first).4.
*  The "Dirty Secret" of Batching (Transaction Management)In a real-world production app, you should set conn. setAutoCommit(false).By default, JDBC is in "Auto-commit" mode.
*  If you have 100 items in a batch and the 50th one fails, some databases might still commit the first 49. For true "all or nothing" logic, you manually call conn.commit() after executeBatch().5.
*  Memory ConstraintsIf you try to batch 1 million rows at once, you might run out of Java Heap Memory.The Fix: "Chunking."
*  Execute the batch every 500 or 1,000 records, then clear it and continue.*/