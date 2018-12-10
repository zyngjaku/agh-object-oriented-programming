package pl.edu.agh.student.zyngier;

public class Main {

    public static void main(String[] args) {
        MaxMultiThread T1 = new MaxMultiThread( "Thread-1");
        T1.start();

        MaxMultiThread T2 = new MaxMultiThread( "Thread-2");
        T2.start();

    }
}
