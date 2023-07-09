package util;

public class VerifyLogin {

    private boolean userVerified = false;
    private boolean adminVerified = false;

    // private static VerifyLogin instance = new VerifyLogin();

    // public VerifyLogin() {
    //     instance = this;
    // }

    // public static VerifyLogin getInstance() {
    //     return instance;
    // }

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
