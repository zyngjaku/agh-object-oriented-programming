import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();
        Punkt3D punkt3d;

        boolean loop = true;

        while(loop) {
            WyswietlMenu();

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch (option){
                case 1:
                    AddPoints(input, punkty);
                    break;
                case 2:
                    if(punkty.size() == 0)
                        System.out.println("Brak dodanych punktów!");
                    else {
                        System.out.println("Wszystkie punkty:");

                        WypiszPunkty(punkty);
                    }
                    break;

                case 3:
                    if(punkty.size() < 2)
                        System.out.println("Nie masz wystarczajacej liczby punktów dodanych (min. 2 punkty)!");
                    else {
                        CalculateDistance(input, punkty);
                    }
                    break;

                case 4: {
                    System.out.println("Bye!");
                    loop = false;
                    break;
                }
            }

        }
    }

    private static void CalculateDistance(Scanner input, LinkedList<Punkt3D> punkty) {
        System.out.println("Wszystkie punkty:");
        WypiszPunkty(punkty);

        System.out.println("Wypierz punkt 1.");
        int a = input.nextInt();

        System.out.println("Wypierz punkt 2.");
        int b = input.nextInt();

        if(a >= punkty.size() || b >= punkty.size())
            System.out.println("Nie ma takiego punktu");
        else
            System.out.println("Odległosc miedzy tymi punktami wynosi: " + punkty.get(a).distance(punkty.get(b)));
    }

    private static void AddPoints(Scanner input, LinkedList<Punkt3D> punkty) {
        System.out.println("Dodawanie punktu...");
        System.out.println("Podaj X: ");
        int x = input.nextInt();
        System.out.println("Podaj Y: ");
        int y = input.nextInt();
        System.out.println("Podaj Z: ");
        int z = input.nextInt();

        punkty.add(new Punkt3D(x, y, z));
    }

    private static void WyswietlMenu() {
        System.out.println("============================");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Wczytaj punkt 3D");
        System.out.println("2. Wyświetl wszystkie punkty");
        System.out.println("3. Oblicz odległość");
        System.out.println("4. Zakończ");
    }

    private static void WypiszPunkty(LinkedList<Punkt3D> punkty) {
        int i = 0;

        for (Punkt3D it : punkty) {
            System.out.println(i + ") X=" + it.getX() + ", Y=" + it.getY() + ", Z=" + it.getZ());

            i++;
        }
    }
}