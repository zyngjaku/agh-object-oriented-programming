package pl.edu.agh.student.zyngier;

import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    static public void cryptfile(File odczyt, File zapis, Algorithm algo) throws FileNotFoundException {
        Scanner in = new Scanner(odczyt);
        PrintWriter out = new PrintWriter(zapis);

        while(in.hasNext()){
            out.print(algo.crypt(in.next() ) + " ");
        }

        out.close();
        in.close();
    }

    static public void decryptfile(File odczyt, File zapis, Algorithm algo) throws FileNotFoundException{
        Scanner in = new Scanner(odczyt);
        PrintWriter out = new PrintWriter(zapis);

        while(in.hasNext()){
            out.print(algo.decrypt(in.next() ) + " ");
        }

        out.close();
        in.close();
    }
}
