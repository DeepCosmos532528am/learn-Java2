package com.sachin;

import java.sql.*;
import java.util.Scanner;

/*
        1. Transaction Explanation (The "All or Nothing" Rule)
Default JDBC mein har line auto-save (Auto-commit) hoti hai. Batching mein hum chahte hain ki agar 100 records mein se ek bhi fail ho, toh pura batch cancel ho jaye. Iske liye hum:
setAutoCommit(false) karte hain (Hath se control lena).
commit() karte hain (Sab sahi raha toh save karo).
rollback() karte hain (Kuch bhi galat hua toh purana data delete mat hone do, reset kar do).
*/
public class JDBCTransaction {


    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "post@MuSiC20042214")) {

            // --- TRANSACTION START ---
            conn.setAutoCommit(false); // Stop auto-saving every row
            // --------------------------

            String query = "Insert into jdbctable (name, salary) values(?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                 Scanner sc = new Scanner(System.in)) {

                while (true) {
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Salary");
                    int salary = sc.nextInt();

                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, salary);
                    preparedStatement.addBatch();

                    System.out.println("Want to add more data?");
                    String toProceed = sc.next();
                    if (toProceed.equals("no")) {
                        int[] update = preparedStatement.executeBatch();

                        // --- TRANSACTION COMMIT ---
                        conn.commit(); // Ab sara data ek sath save hoga
                        System.out.println("Batch Committed Successfully!");
                        // --------------------------
                        break;
                    }
                }
            } catch (Exception e) {
                // --- TRANSACTION ROLLBACK ---
                conn.rollback(); // Agar loop ke beech error aaya, toh batch cancel
                System.out.println("Error occurred, batch rolled back!");
                // ----------------------------
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
* 3. Interview "Deep Knowledge" Points (Quick Recap)
Network Latency: Bina batching ke, Java aur DB ke beech 100 baar "Hello-Hi" hota hai. Batching se ek hi baar mein sara kaam khatam.

Memory vs Performance: 1 Lakh records ko ek sath batch mat karo, warna RAM (Heap Memory) full ho jayegi. 500-1000 ke chunks mein executeBatch() karo.

Why int[]? Ye array batata hai ki batch ki har individual query ne kitne rows update kiye. Interviewer puch sakta hai: "What if 3rd row fails?"—Answer: It throws BatchUpdateException.*/