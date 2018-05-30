package com.example.kavin.wantedxtickets.ModelClasses;

import android.accounts.Account;

public class AccountInformations {
    public String accountName;
    public String locationArea;
    public String firstName;
    public String lastName;
    public String accountPassword;

    public AccountInformations() {
    }

    public AccountInformations(String accountName, String locationArea, String firstName, String lastName, String accountPassword) {
        this.accountName = accountName;
        this.locationArea = locationArea;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountPassword = accountPassword;
    }
}