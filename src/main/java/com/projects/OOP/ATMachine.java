package com.projects.OOP;

import java.util.Scanner;

public class ATMachine {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account user1 = new Account("Sachin Sharma", "7564 2653 4823 6436", "1234", 10000);
        System.out.println("User1, Enter Your PIN");
        String user1join = sc.next();
//        user1.withdraw(5000); //Before logging in with correct credentials would result in Invalid Authentication
        user1.login(user1join);
        user1.depositMoney(2000);
        user1.showBalance();

//Another User, out of n no. of users that we can create in this way

        Account user2 = new Account("Naman Sharma", "1234 5678 9090 4321", "4567", 10000);

        System.out.println("User2, Enter Your PIN");
        String user2join = sc.next();
//        user2.withdraw(1000);
        user2.login(user2join);

//        user2.withdraw(1000);
        user2.showProfile();

    }
}
