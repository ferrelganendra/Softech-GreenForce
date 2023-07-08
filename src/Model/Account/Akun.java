package Model.Account;

public class Akun {
    private String username;
    private String email;
    private String password;

    public Akun(String username, String password, String email) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter dan setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

