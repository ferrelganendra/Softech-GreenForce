package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Model.Account.Komunitas;
import Model.Account.Partisipan;
import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import Model.Kegiatan.JadwalKegiatan;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XMLctrl {

    @SuppressWarnings("unchecked")
    public static ArrayList<Artikel> getArtikel() {
        ArrayList<Artikel> artikelGreenForce = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream artikelInput = null;
        try {
            artikelInput = new FileInputStream("src\\DataBase\\ArtikelData.xml");
            artikelGreenForce = (ArrayList<Artikel>) xstream.fromXML(artikelInput);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (artikelInput != null) {
                try {
                    artikelInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return artikelGreenForce;
    }

    public static void saveArtikel(ArrayList<Artikel> artikel) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlArtikel = xstream.toXML(artikel);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("src\\DataBase\\ArtikelData.xml");
            byte[] bytes = xmlArtikel.getBytes("UTF-8");
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

    @SuppressWarnings("unchecked")
    public static ArrayList<JadwalKegiatan> getJadwalKegiatan() {
        ArrayList<JadwalKegiatan> jadwalKegiatanGreenForce = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream jadwalKegiatanInput = null;
        try {
            jadwalKegiatanInput = new FileInputStream("\\DataBase\\JadwalKegiatanData.xml");
            jadwalKegiatanGreenForce = (ArrayList<JadwalKegiatan>) xstream.fromXML(jadwalKegiatanInput);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jadwalKegiatanInput != null) {
                try {
                    jadwalKegiatanInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jadwalKegiatanGreenForce;
    }

    public static void saveJadwalKegiatan(ArrayList<JadwalKegiatan> jadwalKegiatan) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlJadwalKegiatan = xstream.toXML(jadwalKegiatan);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("\\DataBase\\JadwalKegiatanData.xml");
            byte[] bytes = xmlJadwalKegiatan.getBytes("UTF-8");
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

    @SuppressWarnings("unchecked")
    public static ArrayList<Berita> getBerita() {
        ArrayList<Berita> beritaArrayList = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream beritaInput = null;
        try {
            beritaInput = new FileInputStream("src\\DataBase\\BeritaData.xml");
            beritaArrayList = (ArrayList<Berita>) xstream.fromXML(beritaInput);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (beritaInput != null) {
                try {
                    beritaInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return beritaArrayList;
    }

    public static void saveBerita(ArrayList<Berita> berita) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlBerita = xstream.toXML(berita);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("src\\DataBase\\BeritaData.xml");
            byte[] bytes = xmlBerita.getBytes("UTF-8");
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

    @SuppressWarnings("unchecked")
    public static ArrayList<Partisipan> getUser() {
        ArrayList<Partisipan> partisipanArrayList = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream userInput = null;
        try {
            userInput = new FileInputStream("src\\DataBase\\UserData.xml");
            partisipanArrayList = (ArrayList<Partisipan>) xstream.fromXML(userInput);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (userInput != null) {
                try {
                    userInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return partisipanArrayList;
    }

    public static void saveUser(ArrayList<Partisipan> partisipan) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlUser = xstream.toXML(partisipan);
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

    @SuppressWarnings("unchecked")
    public static ArrayList<Komunitas> getAdmin() {
        ArrayList<Komunitas> partisipanArrayList = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream userInput = null;
        try {
            userInput = new FileInputStream("src\\DataBase\\AdminData.xml");
            partisipanArrayList = (ArrayList<Komunitas>) xstream.fromXML(userInput);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (userInput != null) {
                try {
                    userInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return partisipanArrayList;
    }

}
