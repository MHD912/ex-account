package com.example.accountapp.logic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.accountapp.ui.OutputInterface;

/**
 * This file defines the Account class.  It provides the basis for a
 * series of improvements you'll need to make as you progress through
 * the lessons in Module 6.
 */
public class Account
{
    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */
    final OutputInterface mOut;

    private static int count = 0;
    public static final int RTNUMBER = 844616;
    /**
     * Name of the account holder.
     */
    private String name;

    /**
     * Number of the account.
     */
    private int number;

    /**
     * Current balance in the account.
     */
    private double balance;

    /**
     * Constructor initializes the field
     */
    public Account(OutputInterface out)
    {
        mOut = out;
    }

    // Important note on constructors...
    // Each constructor that you add should take an OutputInterface parameter that
    // is used to initialize mOut (similar to the constructor above).
    // Please remember to add that parameter to the code that you see in the lectures.

    public Account(String newName, OutputInterface out)
    {
        this(out);
        this.name = newName;
        setNumber();
    }

    public Account(String newName, double initialBalance, OutputInterface out)
    {
        this(newName, out);
        this.balance = initialBalance;
    }

    /**
     * Deposit @a amount into the account.
     */
    public void deposit(double amount)
    {
        balance += amount;
    }

    /**
     * Withdraw @a amount from the account.  Prints "Insufficient
     * Funds" if there's not enough money in the account.
     */
    public boolean withdrawal(double amount)
    {
        if (balance > amount)
        {
            balance -= amount;
            return true;
        }
        else
            return false;
    }

    /**
     * Display the current @a amount in the account.
     */
    public void displayBalance()
    {
        mOut.println("The balance on account "
                + number
                + " is "
                + balance);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber()
    {
        this.number = count++;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public double getBalance()
    {
        return balance;
    }

    @NonNull
    @Override
    public String toString()
    {
        return ("Account holder: " + this.getName() + ", Account number: " + this.getNumber());
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Account)
        {
            Account otherAcct = (Account) other;
            return (this.getNumber() == otherAcct.getNumber());
        }
        else    // other object was not an Account
            return false;
    }
}
