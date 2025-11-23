package thread;

public class LoadingThread extends Thread {
    @Override
    public void run() {
        System.out.println("Please wait...");
        try {
            Thread.sleep(600);
        } catch (Exception e) {}
        System.out.println("Done.\n");
    }
}
