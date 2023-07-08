package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Account.Akun;
import Model.Account.Komunitas;
import Model.Account.Partisipan;
import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import Model.Kegiatan.JadwalKegiatan;
import Model.Kegiatan.LaporanKegiatan;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XMLctrl {

    @SuppressWarnings("unchecked")
    public static List<?> getAllList() {
        List<Object> greenForce = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream artikelInput = null;
        FileInputStream beritaInput = null;
        FileInputStream jadwalInput = null;
        FileInputStream laporanInput = null;

        try {
            artikelInput = new FileInputStream("src\\DataBase\\ArtikelData.xml");
            greenForce.addAll((List<Artikel>) xstream.fromXML(artikelInput));
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

        try {
            beritaInput = new FileInputStream("src\\DataBase\\BeritaData.xml");
            greenForce.addAll((List<Berita>) xstream.fromXML(beritaInput));
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

        try {
            jadwalInput = new FileInputStream("src\\DataBase\\JadwalKegiatanData.xml");
            greenForce.addAll((List<JadwalKegiatan>) xstream.fromXML(jadwalInput));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jadwalInput != null) {
                try {
                    jadwalInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            laporanInput = new FileInputStream("src\\DataBase\\LaporanData.xml");
            greenForce.addAll((List<LaporanKegiatan>) xstream.fromXML(laporanInput));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (laporanInput != null) {
                try {
                    laporanInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return greenForce;
    }

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
        ArrayList<JadwalKegiatan> artikelGreenForce = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream jadwalKegiatanInput = null;
        try {
            jadwalKegiatanInput = new FileInputStream("src\\DataBase\\JadwalKegiatanData.xml");
            artikelGreenForce = (ArrayList<JadwalKegiatan>) xstream.fromXML(jadwalKegiatanInput);
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
        return artikelGreenForce;
    }

    public static void saveJadwalKegiatan(ArrayList<JadwalKegiatan> jadwalKegiatan) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlJadwalKegiatan = xstream.toXML(jadwalKegiatan);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("src\\DataBase\\JadwalKegiatanData.xml");
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
    public static ArrayList<LaporanKegiatan> getLaporan() {
        ArrayList<LaporanKegiatan> artikelGreenForce = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream artikelInput = null;
        try {
            artikelInput = new FileInputStream("src\\DataBase\\LaporanData.xml");
            artikelGreenForce = (ArrayList<LaporanKegiatan>) xstream.fromXML(artikelInput);
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

    public static void saveLaporan(ArrayList<LaporanKegiatan> laporan) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlArtikel = xstream.toXML(laporan);
        FileOutputStream coba = null;

        try {
            coba = new FileOutputStream("src\\DataBase\\LaporanData.xml");
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

    public static void saveCurrentAccount(Akun user) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlUser = xstream.toXML(user);
        FileOutputStream coba = null;
        try {
            coba = new FileOutputStream("src\\DataBase\\CurrentAccount.xml");
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
    public static ArrayList<?> getCurrentAccount() {
        ArrayList<?> current = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream userInput = null;
        try {
            userInput = new FileInputStream("src\\DataBase\\CurrentAccount.xml");
            current = (ArrayList<Komunitas>) xstream.fromXML(userInput);
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
        return current;
    }

    public static VerifyLogin getVerify() {
        VerifyLogin partisipanArrayList = new VerifyLogin();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream userInput = null;
        try {
            userInput = new FileInputStream("src\\DataBase\\Verify.xml");
            partisipanArrayList = (VerifyLogin) xstream.fromXML(userInput);
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

    public static void saveVerify(VerifyLogin user) {
        XStream xstream = new XStream(new StaxDriver());
        String xmlUser = xstream.toXML(user);
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
