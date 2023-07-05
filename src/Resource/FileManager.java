package Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}

