package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class Bankservice {

    public boolean validatedata(int principal, int tenure, int age, String gender) throws BankValidationException {
        if (principal < 500) {
            throw new BankValidationException("Principal must be at least 500");
        }
        if (!(tenure == 5 || tenure == 10)) {
            throw new BankValidationException("Tenure must be 5 or 10 years");
        }
        if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            throw new BankValidationException("Gender must be male or female");
        }
        if (age <= 0 || age >= 100) {
            throw new BankValidationException("Invalid age entered");
        }
        return true;
    }
    public void calculate(float principal, int tenure, int age, String gender) {
        try {
            if (validatedata((int) principal, tenure, age, gender)) {
                RDAccount account = new RDAccount(tenure, principal);
                account.setinterest(age, gender);
                float interest = account.calculateinterest();
                float deposited = account.calculateamountdeposited();
                float maturity = account.calculatematurityamount(deposited, interest);
                System.out.println("Interest: " + interest);
                System.out.println("Amount Deposited: " + deposited);
                System.out.println("Maturity Amount: " + maturity);
            }
        } catch (BankValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}