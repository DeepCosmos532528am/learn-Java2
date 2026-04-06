package com.sachin.ExceptionHandling;

//Exception Hierarchy, root is Throwable Class,
//Checked & Unchecked Exceptions,(Only the Runtime Exceptions Subclass and the Error Subclass is unchecked, rest all are checked),
//try{...}catch(){...} block,
//multiple catch blocks for multiple type of Exceptions are allowed,
//try{...}catch(){...} block with finally{...}, finally is basically used to clean up the resources, irrespective of the exception is thrown or not thrown, handled or not, finally{...} always runs


class InvalidSubscriptionException extends Exception { //my custom exception class
    InvalidSubscriptionException(String exception) {
        super(exception);
    }
}

class customerValidity {
    String username = "Sachin";

    void checkValidity(String username) throws InvalidSubscriptionException /* or throws Exception */ {
        if (this.username.equals("") || this.username.equals(null) || !this.username.equals(username)) {
            throw new InvalidSubscriptionException("Cannot Authenticate; invalid username");
        } else {
            System.out.println("User Authentication Successful");
        }
    }
}


public class BookLibrary {
    //Use this when want to actually print the errorMessage in the red text and terminate the program.
    //    static void main() throws InvalidSubscriptionException {
    //        customerValidity cv =new customerValidity();
    //        cv.checkValidity("Sachin");
    //    }

    //OR

    //Use this when want to handle the exception. Yes we can handle, exception of the other place/method(); by throwing the exception object at some condition and handle it at the place of the method call.
    static void main() {
        customerValidity cv = new customerValidity();
        try {
            cv.checkValidity("Sachi");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            System.out.println("Resources releasing up");
        }
    }
}
