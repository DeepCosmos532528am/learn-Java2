package com.projects.OOP;


import java.util.Scanner;

class Account {
    private final String pin; //we would-not hardcode. For such type of initializations where the states are like, without them the Object cannot exist
    //like without the pin, no account. similarly null balance is meaningless, at-least 0 balance is allowed. In the same way we can see the account number. Bro..! How can the account even exist without the AccNo.
    //So would use Constructor (standard approach for such initializations, but in real world the .txt,.csv, or database values are passed in the constructors)
    private float balance;
    private final String userName;
    private final String AccountNumber;
    private boolean isUserValid = false;

    Scanner sc = new Scanner(System.in);

    public Account(String userName, String AccountNumber, String pin, float balance) {
        this.pin = pin;
        this.balance = balance;
        this.userName = userName;
        this.AccountNumber = AccountNumber;
    }

    public void login(String pin) {
        if (this.pin.equals(pin)) {
            isUserValid = true;
            System.out.println("Authentication Successful");
        } else {
            System.out.println("Could not Authenticate");

        }
    }

    public void withdraw(float amountToWithdraw) /*throws Exception*/ {
        if (isUserValid && balance >= amountToWithdraw) {
            balance = balance - amountToWithdraw;
            System.out.printf("Amount:%f\n", amountToWithdraw);

            System.out.println("Press y for see your left Balance,\n Press any key to skip");
            String show_balance = sc.next();
            if (show_balance.equals("y")) {
                showBalance();
            }

        } else {
            System.out.println("Invalid Authentication");
        }


        ThankYou();
    }

    public void depositMoney(float deposit_money) {
        if (isUserValid) {
            balance = deposit_money + balance;
        } else {
            System.out.println("Invalid Authentication");
        }
    }

    public void showBalance() {
        if (isUserValid) {
            System.out.printf("Your Balance is %f\n", balance);
            ThankYou();
        } else {
            System.out.println("Invalid Authentication");
        }
    }

    public void showProfile() {
        if (isUserValid) {
            System.out.printf("User Name: %s\n", userName);
            System.out.printf("Account No.: %s\n", AccountNumber);
            System.out.printf("Account Balance: %f\n", balance);
        } else {
            System.out.println("Invalid Authentication");
        }

    }

    private void ThankYou() {
        System.out.println("Thank you For Using Our Bank, love to serve you");
    }
}

