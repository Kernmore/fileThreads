package threads.four;

import java.io.File;
import java.util.ArrayList;

public class FindFiles implements Runnable {
    private File directory;
    private Thread thread;
    private String name;
    private ArrayList<File> allTheFiles;

    public FindFiles(File directory, String name) {
        this.directory = directory;
        this.name = name;
        allTheFiles = new ArrayList<File>();
        thread = new Thread(this);
        thread.start();
    }

    public ArrayList<File> getAllTheFiles() {
        return allTheFiles;
    }

    private void checkFile(File directory) {

        File[] files = directory.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (equalName(files[i])) {
                        allTheFiles.add(files[i]);
                    }
                } else {
                    checkFile(files[i]);
                }
            }
        }

    }

    public Thread getThread() {
        return thread;
    }

    public boolean equalName(File file) {
        if (file.getName().equals(name)) {
            return true;
        }
        return false;
    }


    @Override
    public void run() {
        checkFile(directory);
    }
}
