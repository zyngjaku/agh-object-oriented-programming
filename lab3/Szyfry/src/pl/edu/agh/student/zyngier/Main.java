package pl.edu.agh.student.zyngier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        File pierwszy = new File(args[0]);
        File drugi = new File(args[1]);

        System.out.println("1. Szyfruj Polibiusz");
        System.out.println("2. Odszyfruj Polibiusz");
        System.out.println("3. Szyfruj ROT11");
        System.out.println("4. Odszyfruj ROT11");
        System.out.println("0. Wyjdź");

        int option = in.nextInt();

        switch(option){
            case 1:
                Cryptographer.cryptfile(pierwszy, drugi, new ROT11());
                break;
            case 2:
                Cryptographer.cryptfile(pierwszy, drugi, new Polibiusz());
                break;
            case 3:
                Cryptographer.decryptfile(pierwszy, drugi, new ROT11());
                break;
            case 4:
                Cryptographer.decryptfile(pierwszy, drugi, new Polibiusz());
                break;
        }

        in.close();
    }
}