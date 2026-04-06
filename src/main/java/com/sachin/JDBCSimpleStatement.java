package com.sachin;

import java.sql.*;


public class JDBCSimpleStatement {
    static final String url = "jdbc:postgresql://localhost:5432/alpha";
    private static final String username = "postgres";
    private static final String password = "post@MuSiC20042214";


    public void main(String[] args) {
        /*
         * Pehle ke time (Java 7 se pehle) humein yeh manually karna padta tha.
         * Lekin ab JDBC 4.0+ mein:
         * Java khud hi Maven ki files scan kar leta hai.
         * Woh khud hi Driver dhoond leta hai.
         * Woh khud hi use load aur register bhi kar deta hai.
         * Isliye aaj kal log Class.forName() ko sirf Debug karne ke liye likhte hain, taaki agar driver missing ho toh program wahin ruk jaye aur error dikha de.
         *
         */

//        try {
//            Class.forName("org.postgresql.Driver");
//            System.out.println("Successfully Connected");
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }

        try (
                Connection connection = DriverManager.getConnection(url, username, password); //On this line the JDBC boilerplate code ends
                // yaha pe Connection ek interface h,
                // DriverManager is the class with static getConnection method, this getConnection() matches the url with the various driver,
                // and returns the suitable DriverObject like PgConnection Object here, this PgConnection Class implements the Connection
                // Interface in the backend.


                Statement statement = connection.createStatement();// here connection holds the PgConnection Object as we already know,
                // createStatement returns an PgStatement Object whose corresponding class actually implements s the Statement Interface.

        ) {
            //For Retrieving data
            String query = "Select cust_id, name from customer";

            try (ResultSet resultSet = statement.executeQuery(query);) {
                /*
                 * Jab tum statement.executeQuery(query) likhte ho, toh badle mein tumhe ResultSet milta hai. Chalo dekhte hain ye kya cheez hai aur iske andar kya chhupa hota hai.
                 * 1. ResultSet Kya Hold Karta Hai?
                 * Technical bhasha mein: ResultSet ek Tabular Data Structure hold karta hai.
                 * Simple bhasha mein: Yeh ek Virtual Table hold karta hai jo tumhari SQL SELECT query ka nateeja (result) hoti hai.
                 * Ismein do cheezein hoti hain:
                 * Data Rows: Jo rows tumne query se mangwayi hain.
                 * Cursor: Yeh sabse important part hai. ResultSet ek Cursor (Pointer) maintain karta hai jo abhi "Pehli row se bhi upar" hota hai.
                 * 2. Ye Object Kaise Milta Hai? (The Same Pattern)
                 * Yahan bhi wahi Interface vs Implementation wala khel hai:
                 * ResultSet ek Interface hai.
                 * Jab tum executeQuery() call karte ho, toh PostgreSQL ka driver piche se ek class ka object bhejta hai (Jaise PgResultSet).
                 * Tum use ResultSet ke reference mein pakadte ho.
                 * 3. Ye Kaam Kaise Karta Hai? (The Iterator)
                 * ResultSet ko tum ek "List" ki tarah imagine kar sakte ho, lekin isse read karne ka ek khaas tarika hota hai—next() method ka use karke.
                 * Jab ResultSet banta hai, toh cursor Row 0 (headers ke upar) par hota hai.
                 * Jab tum rs.next() call karte ho, cursor pehli row par aata hai.
                 * Agar row milti hai, toh yeh true return karta hai, warna false.
                 * */

                System.out.println("cust_id  name ");

                while (resultSet.next()) { //loop to iterate over the table rows, without this the required output would not come.
                    int cust_id = resultSet.getInt("cust_id");
                    String name = resultSet.getString("name");

                    System.out.println(cust_id + "       " + name);
                }

            }


            //For Update
            String uquery = "update customer set name = 'Preyasi Sharma' where cust_id= 11";
            int rowsAffected = statement.executeUpdate(uquery);
            if (rowsAffected > 0) {
                System.out.println("Success! " + rowsAffected + " row(s) update ho gayi.");
            } else {
                System.out.println("Oops! Koi row match nahi hui, isliye update nahi hua.");
            }


        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        /*
         * Connection connection: Yeh ek Interface Reference hai jo java.sql package se aata hai. Yeh hamare liye ek "Session" ya "Rasta" hai database tak pahunchne ka.
         * DriverManager: Yeh ek Class hai (Manager ki tarah), jo saare available drivers ko manage karti hai.
         * getConnection(url, user, pass): Yeh DriverManager ki ek Static Method hai.
         * Matching Process: Yeh method tumhare provide kiye gaye url (jaise jdbc:postgresql://...) ko register kiye gaye saare drivers ke saath match karti hai.
         * Driver's Job: Jab use PostgreSQL ka driver mil jata hai, toh woh driver piche se apni Concrete Implementation Class (jaise PgConnection) ka Object create karta hai. ye PgConnection class implements Connection Interface, issi Kaaran se uska PgConnection object Connection interface ke reference me store ho pata h
         * Upcasting (The Final Result): Woh PgConnection ka object return hota hai aur Connection interface ke variable mein store ho jata hai. Isse "Upcasting" kehte hain, aur isi wajah se humein Interface ka object milta hua lagta hai.
         */

        /*
         * Jab tum likhte ho:
         * Statement statement = connection.createStatement();
         * Yahan connection (jo asal mein PgConnection ka object hai) ek factory ki tarah kaam karta hai aur tumhe PgStatement ka object bana kar deta hai.
         * Lekin tum use Statement (Interface) ke reference mein pakadte ho.
         */


    }
}