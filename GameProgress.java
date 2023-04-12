package JavaCore.HomeWork.StreamsFilesSerializable1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void main(String[] args) {

        GameProgress game1 = new GameProgress(100, 1, 1, 100);
        GameProgress game2 = new GameProgress(85, 3, 3, 350);
        GameProgress game3 = new GameProgress(35, 4, 5, 550);

        saveGame("/Users/dmitrymurin/Games/savegames/save.dat", game1);
        saveGame("/Users/dmitrymurin/Games/savegames/save2.dat", game2);
        saveGame("/Users/dmitrymurin/Games/savegames/save3.dat", game3);

        List<String> list = new ArrayList<>();
        list.add("/Users/dmitrymurin/Games/savegames/save.dat");
        list.add("/Users/dmitrymurin/Games/savegames/save2.dat");
        list.add("/Users/dmitrymurin/Games/savegames/save3.dat");

        zipFiles("/Users/dmitrymurin/Games/savegames/zip.zip", list);

        for (String s : list) {
            File file = new File(s);
            file.delete();
        }
    }

    public static void saveGame(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String path, List<String> pathesToFiles) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path));
        ) {
            for (String s : pathesToFiles) {
                try (FileInputStream fis = new FileInputStream(s)
                ) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);

                    Path path2 = Paths.get(s);
                    Path fileName = path2.getFileName();

                    ZipEntry entry = new ZipEntry(fileName.toString());
                    zout.putNextEntry(entry);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

