package org.example;

import java.io.File;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Games/GunRunner/savegames/";
        String fileName = "save";
        String fileExtension = ".dat";
        WorkWithOS workWithOS = new WorkWithOS();
        workWithOS.createDirectory(path);
        for (int i = 0; i < 3; i++) {
            GameProgress gameProgress = new GameProgress((int) (Math.random() * 3), (int) (Math.random() * 3), (int) (Math.random() * 3), Math.random());
            workWithOS.saveGame(path + fileName + i + fileExtension, gameProgress);
            workWithOS.zipFiles(path + "zip" + i + ".zip", path + fileName + i + fileExtension, fileName + i + fileExtension);
            workWithOS.delFiles(path + fileName + i + fileExtension);
        }

    }
}