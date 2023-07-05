package DataBase;

import java.util.ArrayList;
import java.util.List;

import Model.Account.Akun;

public class AkunStorage {

    private static List<Akun> accountList = new ArrayList<>();

    public static void addAccount(Akun account) {
        accountList.add(account);
    }

    public static Akun getAccountByUsername(String username) {
        for (Akun account : accountList) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }
}
