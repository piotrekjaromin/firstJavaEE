package com.lab3.zad1.dto;

import java.util.Date;

/**
 * Created by piotrek on 26.03.16.
 */
public class User {
    private String login;
    private String password;
    private Date loginDate;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.loginDate = new Date();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String toString(){
        return "login: " + login + " date: " + loginDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return !(loginDate != null ? !loginDate.equals(user.loginDate) : user.loginDate != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        return result;
    }
}
