package pl.edu.agh.student.zyngier;

public class Main {

    public static void main(String[] args) {
        System.out.println("Głowny watek: początek");
        System.out.println("Główny wątek: tworzenie nowego wątku");

        MaxMultiThread max = new MaxMultiThread();
        max.start();

        try{
            for(int i=5; i>0; i--){
                System.out.println("Główny wątek " + i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Główny wątek: koniec");


    }
}
