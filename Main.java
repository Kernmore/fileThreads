package threads.four;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /**
         * Put your directories below:
         */
//        File folderIn = new File("Pack");
//        File folderOut = new File("Rust");
//        CopyDirectory copyDirectory = new CopyDirectory();
//        copyDirectory.countFiles(folderIn);
//        copyDirectory.setDestinationFolder(folderOut);
//        int n = copyDirectory.getCount();
//
//        Thread[] threads = new Thread[n];
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new Thread(copyDirectory);
//            threads[i].start();
//            try {
//                Thread.currentThread().sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        CheckingFiles checkingFiles = new CheckingFiles(folderOut);
//        Thread thread = new Thread(checkingFiles);
//        thread.start();
//        checkFile(directory);
//        for (File file : allTheFiles) {
//            System.out.println(file.getAbsoluteFile());
//        }
        /**
         * @directory - the directory where you want to search the files with the same name
         * @name - the name of the searched files
         */

        File directory = new File("C:\\Users\\User\\IdeaProjects\\ProgAcademy\\untitled\\src");
        String name = "ddd.txt";

        ListDirectory.createThreads(directory, name);

    }

}
