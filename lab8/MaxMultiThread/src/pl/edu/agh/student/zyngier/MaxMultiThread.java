package pl.edu.agh.student.zyngier;

public class MaxMultiThread extends  Thread {
    public void run(){
        System.out.println("\tNowy wątek: początek");
        try{
            for(int i=5; i>0; i--){
                System.out.println("\tNowy wątek " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("\tNowy wątek: koniec");
    }
}
