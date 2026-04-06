package com.sachin.Encapsulation;

class BankAccount {
    // 1. Data Hiding: Koi bahar se balance ko direct nahi chhed sakta
    private double balance = 100000;

    // 2. Controlled Access: Sirf is method ke through balance dekh sakte ho
    public String getBalance(String pin) {
        if (pin.equals("1234")) {
            return "Your Balance: " + balance;
        }
        return "Wrong PIN! Access Denied.";
    }

    // 3. Validation Magic: Negative value ya faltu update prevent karna
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid amount! Kya kar raha hai bhai?");
        }
    }
}


public class Encapsulation {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount();
        myAcc.deposit(3000);
//       myAcc.balance = -500; // YE ERROR DEGA (Direct access blocked!)
//        System.out.println(myAcc.balance); // YE ERROR DEGA (Direct access blocked!)
        myAcc.deposit(5000); // Sahi tarika
        System.out.println(myAcc.getBalance("1234")); // Rules ke saath access
    }
}
/*
 * Iska "Asli Magic" teen cheezon ka combo hai:
 *
 * 1. **Binding (The Glue)**: Data aur methods ko ek Class ke andar lapet dena.
 *    - **Java Example**:
 *    class SmartDevice {
 *        private int volume; // Data aur Method ek hi boundary mein bind hain
 *        public void changeVolume(int v) { this.volume = v; }
 *    }
 *
 * 2. **Hiding (The Shield)**: `private` keyword use karke data ko bahar se invisible kar dena.
 *    - **Java Example**:
 *    class BankAccount {
 *        private double balance = 1000; // Bahar se access nahi ho sakta
 *        public double getBalance() { return balance; } // Sirf yahan se dikhega
 *    }
 *
 * 3. **Control (The Filter)**: Setters aur Getters par conditions lagana.
 *    - **Java Example**:
 *    class Admission {
 *        private int studentAge;
 *        public void setStudentAge(int age) {
 *            if (age >= 5 && age <= 18) {
 *                this.studentAge = age;
 *                System.out.println("Entry Granted!");
 *            } else {
 *                System.out.println("Entry Denied: Age criteria match nahi hua.");
 *            }
 *        }
 *    }
 *
 * **Conclusion**:
 * Encapsulation ka matlab hai—"Mera data, mere rules."
 * Bina encapsulation ke, tumhara variable ek khuli tijori hai, koi bhi usme galat data daal sakta hai.
 * Encapsulation us tijori par ek "Smart Filter" laga deta hai.
 */

