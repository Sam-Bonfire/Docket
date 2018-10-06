package com.houseofivy.docket;

public class userProfile {
    public String userName;
    public String userEmail;
    public  String userRole;

    public userProfile(){

    }

    public userProfile(String userName, String userEmail,String userRole) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRole=userRole;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
