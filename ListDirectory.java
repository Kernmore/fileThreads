package threads.four;

import java.io.File;
import java.util.HashSet;

public class ListDirectory {
    public static void createThreads(File directory, String name) {
        File[] files = directory.listFiles();
        int fileCount = directory.listFiles().length;
        int threadNumber = countThreads(fileCount);
        int fileNumber = fileCount / threadNumber + 1;

        FindFiles[] listDirectories = new FindFiles[threadNumber];
        for (int i = 0, n = 0; i < threadNumber; i++) {
            File[] temp = new File[fileNumber];
            for (int j = 0; j < temp.length && n < files.length; j++) {
                temp[j] = files[n];
                n++;

            }
            listDirectories[i] = new FindFiles(temp, name);
        }

        try {
            for (int i = 0; i < listDirectories.length; i++) {
                listDirectories[i].getThread().join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showFiles(listDirectories);
    }

    private static int countThreads(int length) {
        int number = 1;
        if (length < 10) {
            return 3;
        } else if (length < 25) {
            return 10;
        } else if (length < 100) {
            return 20;
        } else if (length > 100) {
            return 40;
        }
        return number;
    }


    /**
     * HashSet used instead of ArrayList to remove the identical names
     *
     * @param directories
     */
    private static void showFiles(FindFiles[] directories) {
        HashSet<File> allTheFiles1 = new HashSet<>();
        for (int i = 0; i < directories.length; i++) {
            allTheFiles1.addAll(directories[i].getAllTheFiles());
        }
        for (File file : allTheFiles1) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}
