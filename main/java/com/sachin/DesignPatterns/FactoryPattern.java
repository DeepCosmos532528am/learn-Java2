package com.sachin.DesignPatterns;

public class FactoryPattern{
    static void main() {


        Customer customer = FP.getInstanceOfCustomer("Premium");
        System.out.println(customer);

        Customer customer2 = FP.getInstanceOfCustomer("Regular");
        System.out.println(customer2);

        System.out.println(customer);
        System.out.println(customer2);

        System.out.println(customer == customer2);

    }
}

//Below is the full implementation of how to design Factory Pattern

interface Customer {
    void createCustomer();
        }

        class RegularCustomer implements Customer {
        @Override
        public void createCustomer() {
            System.out.println("0% Discount");
        }
        }

        class PremiumCustomer implements Customer {
        @Override
        public void createCustomer() {
            System.out.println("40% Discount");
        }
        }


class FP {
        private FP(){
        }
        public static Customer getInstanceOfCustomer(String customerType){

               if(customerType.equalsIgnoreCase("RegularCustomer")){
                   return new RegularCustomer();
               }else if(customerType.equalsIgnoreCase("PremiumCustomer")){
                   return new PremiumCustomer();
               }
               return null;
        }
}
