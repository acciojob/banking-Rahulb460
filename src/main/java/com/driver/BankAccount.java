package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance + minBalance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw  exception
        String str = Integer.toString(digits);
//        for(int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if(ch < 0 || ch > 9) {
//
//            }
//        }
        int sumOfDigits = 0;
        while (digits != 0) {
            sumOfDigits = sumOfDigits + digits % 10;
            digits = digits / 10;
        }
        if(sumOfDigits == sum) {
            return  str;
        }
        else{
            throw new Exception("Account Number can not be generated");
        }
//        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance = balance + amount;
//        System.out.println("balance-->" + balance);

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "" exception, if the remaining amount would be less than minimum balance
        if (amount > balance || balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
       else {
            balance = balance - amount;
//            System.out.println("balance-->" + balance);
        }
    }
}