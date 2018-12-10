package pl.edu.agh.student.zyngier;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<MaxMultiThread> lista = new ArrayList<MaxMultiThread>();

        for(int i=0; i<100; i++){
            lista.add(new MaxMultiThread(""+i));
            lista.get(i).start();
        }
    }
}
