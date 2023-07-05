package DataBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import Model.Account.Partisipan;

public class AkunStorage {

    public static void main(String[] args) {
        ArrayList<Partisipan> accountList = new ArrayList<>();

        Partisipan user = new Partisipan("User", "User123", "user0@gmail.com");

        accountList.add(user);

        XStream xstream = new XStream(new StaxDriver());
        String xmlUser = xstream.toXML(accountList);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("src\\DataBase\\UserData.xml");
            byte[] bytes = xmlUser.getBytes("UTF-8");
            coba.write(bytes);
        } catch (Exception e) {
            System.out.println("WARNING: " + e.getMessage());
        } finally {
            if (coba != null) {
                try {
                    coba.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
