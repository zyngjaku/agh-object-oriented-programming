import java.awt.*;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Shape> ksztalty = new LinkedList<Shape>();

        boolean runningProgram = true;

        while(runningProgram) {
            System.out.print("1.Trójkąt\n2.Kwadrat\n3.Wypisz\n4.Zakończ\n\n");
            Scanner odczyt = new Scanner(System.in);
            int i = odczyt.nextInt();
            if (i == 1) {
                System.out.print("Podaj nazwę\n");
                odczyt = new Scanner(System.in);
                Shape t = new Triangle();
                t.name = odczyt.nextLine();
                ksztalty.add(t);
            } else if (i == 2) {
                System.out.print("Podaj nazwę\n");
                odczyt = new Scanner(System.in);
                Shape s = new Square();
                s.name = odczyt.nextLine();
                ksztalty.add(s);
            } else if (i == 3) {
                Collections.sort(ksztalty, new Comparator<Shape>() {
                    @Override
                    public int compare(Shape s1, Shape s2) {
                        return Collator.getInstance().compare(s1.name, s2.name);
                    }
                });

                for (Shape n : ksztalty) {
                    System.out.println(n.name + ": ");
                    n.draw();
                }
            } else if (i == 4) {
                runningProgram = false;
            }
        }


    }
}
