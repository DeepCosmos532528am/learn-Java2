package com.sachin;

import java.util.Scanner;

public class myloginAccount_basic {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Scanner sc = new Scanner(System.in);
        System.out.println(account_info("Krishna"));
        int a = 20;
        String status = "name";
        System.out.println((a > 18) ? "Greater then 18" : "Not greater than 18");
    }

    public static String account_info(String customerName) {
        Boolean verifyCustomer = customers(customerName);
        int totalMoney = 100000;
        if (verifyCustomer) {
            return "Your Total Money in Your Bank Account is:" + totalMoney;
        }
        return "Sorry could not validate you, please enter correct credentials";
    }


    public static Boolean customers(String customerName) {
        String[] customer = {"Sachin", "Krishna"};
        Boolean customerExists = false;
        for (String cName : customer) {
            if (cName.equals(customerName)) {
                customerExists = true;
                return customerExists;

            }
        }
        return false;
    }

    void func1( int a,int b) {
    }

    void func1(String a, int b) {
    }
}

