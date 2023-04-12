//https://github.com/netology-code/jd-homeworks/blob/master/files/task1/README.md
package JavaCore.HomeWork.StreamsFilesSerializable1;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        File dir = new File("/Users/dmitrymurin/Games/src");
        if (dir.mkdir())
            builder.append("The directory 'src' has been created").append("\n");

        File dir2 = new File("/Users/dmitrymurin/Games/res");
        if (dir2.mkdir())
            builder.append("The directory 'res' has been created").append("\n");

        File dir3 = new File("/Users/dmitrymurin/Games/savegames");
        if (dir3.mkdir())
            builder.append("The directory 'savegames' has been created").append("\n");

        File dir4 = new File("/Users/dmitrymurin/Games/temp");
        if (dir4.mkdir())
            builder.append("The directory 'temp' has been created").append("\n");

        File dir5 = new File("/Users/dmitrymurin/Games/src/main");
        if (dir5.mkdir())
            builder.append("The directory 'main' has been created").append("\n");

        File dir6 = new File("/Users/dmitrymurin/Games/src/test");
        if (dir6.mkdir())
            builder.append("The directory 'test' has been created").append("\n");

        File file = new File("/Users/dmitrymurin/Games/src/main", "Main.java");
        try {
            if (file.createNewFile())
                builder.append("File 'Main.java' has been created").append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File file2 = new File("/Users/dmitrymurin/Games/src/main", "Utils.java");
        try {
            if (file2.createNewFile())
                builder.append("File 'Utils.java' has been created").append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dir7 = new File("/Users/dmitrymurin/Games/res/drawables");
        if (dir7.mkdir())
            builder.append("The directory 'drawables' has been created").append("\n");

        File dir8 = new File("/Users/dmitrymurin/Games/res/vectors");
        if (dir8.mkdir())
            builder.append("The directory 'vactors' has been created").append("\n");

        File dir9 = new File("/Users/dmitrymurin/Games/res/icons");
        if (dir9.mkdir())
            builder.append("The directory 'icons' has been created").append("\n");

        File file3 = new File("/Users/dmitrymurin/Games/temp", "temp.txt");
        try {
            if (file3.createNewFile())
                builder.append("File 'temp.txt' has been created").append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String log = builder.toString();

        try (FileWriter writer = new FileWriter("/Users/dmitrymurin/Games/temp/temp.txt")) {
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
