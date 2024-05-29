package com.hungh2002.model.customer;

/**
 * customer
 */
public class Customer {

    private int id;
    private String username;
    private String password;
    private String sessionId;


    public Customer() {}

    public Customer(int id, String username, String password, String sessionId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sessionId = sessionId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
