package threads.four;

import java.io.File;
import java.util.HashSet;

public class ListDirectory {
    public static void createThreads(File directory, String name) {
        File[] files = directory.listFiles();
        int count = 0;
        int number = countDirectories(files);
        FindFiles[] directories = new FindFiles[number + 1];

        directories[files.length - 1] = new FindFiles(directory, name);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                directories[count] = new FindFiles(files[i], name);
                count++;
            }
        }
        try {
            for (int i = 0; i < directories.length; i++) {
                directories[i].getThread().join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showFiles(directories);

    }


    public static int countDirectories(File[] files) {
        int number = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                number++;
            }
        }
        return number;
    }

    /**
     * HashSet used instead of ArrayList to remove the identical names
     * @param directories
     */
    private static void showFiles(FindFiles[] directories){
        HashSet<File> allTheFiles1 = new HashSet<File>();
        for (int i = 0; i < directories.length; i++) {
            allTheFiles1.addAll(directories[i].getAllTheFiles());
        }
        for (File file : allTheFiles1) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}
