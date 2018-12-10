package pl.edu.agh.student.zyngier;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {

    public int number;
    public Fork leftFork;
    public Fork rightFork;
    public boolean canIAskWaiter = false;
    public boolean IamEating = false;

    Philosopher(int num, Fork left, Fork right) {
        number = num;
        leftFork = left;
        rightFork = right;
    }

    public void run(){
        System.out.println("FIlozof #" + number);

        while (true) {
            think();

            if(canIAskWaiter && askWaiter() || !canIAskWaiter) {
                leftFork.grab();
                System.out.println("Filozof #" + number + " wziął lewy widelec.");
                rightFork.grab();
                System.out.println("Filozof #" + number + " wziął prawy widelec.");
                IamEating = true;
            }

            if(IamEating) {
                eat();
                leftFork.release();
                System.out.println("Filozof #" + number + " odłożył lewy widelec.");
                rightFork.release();
                System.out.println("Filozof #" + number + " odłożył prawy widelec.");
                IamEating = false;
            }
        }
    }

    void think() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("Filozof #" + number + " myślał przez " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("Filozof #" + number + " zakończył jedzenie " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void solveTheProblem(){
        canIAskWaiter=true;
    }

    public boolean askWaiter(){
        if(leftFork.isFree() && rightFork.isFree()){
            System.out.println("Kelner: możesz wziać oba widelce!");
            return true;
        }
        else{
            System.out.println("Kelner: przykro mi ale nie mozesz teraz zjeść!");
        }
        return false;
    }


}
