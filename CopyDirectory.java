package threads.four;

import java.io.*;

public class CopyDirectory implements Runnable {
    private File[] files;
    private int count;
    private File destinationFolder;

    public void setDestinationFolder(File destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    public int countFiles(File folder) {
        File[] temp = folder.listFiles();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].isFile()) {
                count++;
            }
        }
        this.files = copyArray(temp);
        return count;
    }

    public static long copyFile(File fileIn, File fileOut) throws IOException {
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            return is.transferTo(os);
        }
    }

    private File[] copyArray(File[] array) {
        File[] files1 = new File[count];
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                files1[number] = array[i];
                number++;
            }
        }
        return files1;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        File file = files[count - 1];
        try {
            copyFile(file, new File(destinationFolder + "\\" + file.getName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        count--;

    }


}
