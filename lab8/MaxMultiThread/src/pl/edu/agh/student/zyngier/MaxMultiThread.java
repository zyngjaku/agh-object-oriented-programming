package pl.edu.agh.student.zyngier;

public class MaxMultiThread extends Thread {
    private Thread t;
    private String threadID;
    public String builder;

    MaxMultiThread(String id) {
        threadID = id;
        builder="";

        System.out.println("Creating " + threadID);
    }

    public void run() {
        System.out.println("Running " + threadID);

        try {
            for(int i = 0; i < 10000; i++) {
                builder+= threadID + " ";
                System.out.println("Thread #" + threadID + ": " + builder);

                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadID + " interrupted.");
        }

        new GenerateRandoms(builder);
        System.out.println("Thread " + threadID + " exiting.");
    }

    public void start () {
        System.out.println("Starting " + threadID);

        if (t == null) {
            t = new Thread (this, threadID);
            t.start ();
        }
    }
}
