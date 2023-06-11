package org.example;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WorkWithOS {
    public void createDirectory(String dirpath) {
        File directory = new File(dirpath);
        if (directory.mkdirs()) {
            System.out.println("Directory created successfully");
        } else
            System.out.println("ERROR not directory created");
        {
        }
    }

    public void createFileData(String filename, String dirpath) {
        File newFile = new File(dirpath, filename);
        try {
            if (newFile.createNewFile())
                System.out.println("File created successfully");
            else
                System.out.println("ERROR file not created ");
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    public void saveGame(String path, GameProgress gameProgress) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String pathZip, String pathFile, String fileName) {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip));
             FileInputStream fis = new FileInputStream(pathFile)) {
            ZipEntry entry = new ZipEntry(fileName);
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void delFiles(String pathFile) {
        File file = new File(pathFile);
        file.delete();
    }
}
