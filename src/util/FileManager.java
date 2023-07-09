package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import Model.Artikel.Artikel;
import Model.Artikel.Berita;
import Model.Kegiatan.JadwalKegiatan;
import Model.Kegiatan.LaporanKegiatan;

public class FileManager {

    public static void saveImageToResourceFolder(File selectedFile) {
        String projectPath = System.getProperty("user.dir");
        String resourceFolderPath = projectPath + "/src/Resource/";

        try {
            Path sourcePath = selectedFile.toPath();
            String fileName = selectedFile.getName();

            Path destinationPath = Paths.get(resourceFolderPath + fileName);
            Files.copy(sourcePath, destinationPath);
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }

    public static void deleteImageFromResource(String imagePath) {
        List<?> allList = XMLctrl.getAllList();
        boolean fileNotUsed = true;
        for (Object obj : allList) {
            if (obj instanceof Artikel) {
                Artikel artikel = (Artikel) obj;
                if (artikel.getImgSrc().equals(imagePath)) {
                    fileNotUsed = false;
                    break;
                }
            } else if (obj instanceof Berita) {
                Berita berita = (Berita) obj;
                if (berita.getImgSrc().equals(imagePath)) {
                    fileNotUsed = false;
                    break;
                }
            } else if (obj instanceof JadwalKegiatan) {
                JadwalKegiatan jadwal = (JadwalKegiatan) obj;
                if (jadwal.getImgSrc().equals(imagePath)) {
                    fileNotUsed = false;
                    break;
                }
            } else if (obj instanceof LaporanKegiatan) {
                LaporanKegiatan laporan = (LaporanKegiatan) obj;
                if (laporan.getImgSrc().equals(imagePath)) {
                    fileNotUsed = false;
                    break;
                }
            }
        }
        if (fileNotUsed) {
            String relativePath = imagePath.replace("../", "src/");
            File file = new File(relativePath);

            if (file.exists() && file.isFile()) {
                boolean deleted = file.delete();
                if (deleted) {
                    System.out.println("Gambar berhasil dihapus.");
                } else {
                    System.out.println("Gagal menghapus Gambar.");
                }
            }
        } else {
            System.out.println("Gambar sedang digunakan, tidak bisa menghapus Gambar tersebut");
        }
    }

}
