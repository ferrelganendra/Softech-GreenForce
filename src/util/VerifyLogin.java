package util;

import java.util.ArrayList;

import Model.Account.Partisipan;

public class VerifyLogin {

    public static boolean verifyUserLoginStatus(ArrayList<Partisipan> user) {
        boolean verified = false;
        user = XMLctrl.getUser();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equals(user.get(i).getUsername()) &&
                    user.get(i).getEmail().equals(user.get(i).getEmail())) {
                verified = true;
            }
        }
        return verified;
    }

    // public static boolean verifyUserLoginStatus(ArrayList<Partisipan> user) {
    // boolean verified = false;
    // ArrayList<Partisipan> userList = XMLctrl.getUser();
    // for (Partisipan partisipan : userList) {
    // int i = 0;
    // if (partisipan.getUsername().equals(user.get(i).getUsername()) &&
    // partisipan.getEmail().equals(user.get(i).getEmail())) {
    // verified = true;
    // break;
    // }
    // i++;
    // }
    // return verified;
    // }

    private boolean userVerified = false;
    private boolean adminVerified = false;

    private static VerifyLogin instance = new VerifyLogin();

    public VerifyLogin() {
        instance = this;
    }

    public static VerifyLogin getInstance() {
        return instance;
    }

    public boolean isVerifiedUser() {
        return userVerified;
    }

    public boolean isVerifiedAdmin() {
        return adminVerified;
    }

    public void setUserVerified(boolean userVerified) {
        this.userVerified = userVerified;
    }

    public void setAdminVerified(boolean adminVerified) {
        this.adminVerified = adminVerified;
    }

}
