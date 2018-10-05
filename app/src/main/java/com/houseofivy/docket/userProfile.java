package com.houseofivy.docket;

public class userProfile {
    public String userName;
    public String userEmail;

    public userProfile(){

    }

    public userProfile(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;

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


}
