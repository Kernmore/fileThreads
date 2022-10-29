package threads.four;

import java.io.File;

public class CheckingFiles implements Runnable{
    private File directory;
    private int number;

    public CheckingFiles(File directory){
        this.directory = directory;
        this.number = checkDirectory(directory);
    }


    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public int checkDirectory(File file){
        File[] temp = directory.listFiles();
        int digit = 0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].isFile()) {
                digit++;
            }
        }
        return digit;
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        for (; ; ) {
            try {
                thr.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (checkDirectory(directory) > number) {
                System.out.println("The file was added");
            } else if (checkDirectory(directory) < number){
                System.out.println("The file was removed");
            }
            number = checkDirectory(directory);
        }
    }
}
