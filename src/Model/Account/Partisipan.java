package Model.Account;

import java.util.Random;

public class Partisipan extends Akun {
    private final String ID;

    public Partisipan(String name, String password, String email) {
        super(name, password, email);
        this.ID = generateID(10);
    }

    private static String generateID(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public String getID() {
        return ID;
    }

}