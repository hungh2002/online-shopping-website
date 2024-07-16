package com.hungh2002.model.customer;

/**
 * customer
 */
public class Customer {

    private long customerId;
    private String username;
    private String password;
    private String sessionId;


    public Customer() {}

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(long customerId, String username, String password, String sessionId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.sessionId = sessionId;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Cannot be a negative number or 0");
        }
        this.customerId = customerId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
