package pl.edu.agh.student.zyngier;

import pl.edu.agh.student.zyngier.Fork;
import pl.edu.agh.student.zyngier.Philosopher;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String argv[]) {
        System.out.println("Zacznijmy ucztę filozofów!");

        Philosopher philosophers[] = new Philosopher[5];
        Fork forks[] = new Fork[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1)%5]);
            philosophers[i].start();
            //philosophers[i].solveTheProblem();
        }

        while (true) {
            try {
                Thread.sleep(1000);

                boolean deadlock = true;
                for (Fork f : forks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Koniec uczty!!");
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Bye!");
        System.exit(0);
    }

}