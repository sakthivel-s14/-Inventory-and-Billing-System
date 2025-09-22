package com.wipro.bank.exception;

public class BankValidationException extends Exception {
    public BankValidationException(String message) {
        super(message); // this comes from java.lang.Exception
    }
}