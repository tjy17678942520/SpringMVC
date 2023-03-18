package edu.beihua.domain;

public class User {
    private String uname;
    private int uage;

    public User() {
    }

    public User(String uname, int uage) {
        this.uname = uname;
        this.uage = uage;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }
}
