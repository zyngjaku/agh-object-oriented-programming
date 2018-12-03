package pl.edu.agh.student.zyngier;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();

        int count_attemp=0;
        while(!db.isConnect() && count_attemp<3) {
            if(count_attemp!=0) System.out.println("Ponawiam połączenie");

            db.connect();
            count_attemp++;
        }

        if(db.isConnect()) {
            while (true) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Co chcesz zrobić?\n1.Wyswietl ksiażki\n2.Szukaj książki\n3.Dodaj ksiażkę\n4.Zakończ\n");
                int i = keyboard.nextInt();

                if (i == 1) {
                    db.getBooks();
                } else if (i == 2) {
                    System.out.println("Szukaj według:?\n1.numeru ISBN\n2.autora\n");
                    int element = keyboard.nextInt();

                    Scanner sc = new Scanner (System.in);
                    System.out.println("Podaj wartość do szukania:");
                    String value = sc.nextLine();

                    if(element==1) db.searchBooks("isbn", value);
                    else if(element==2) db.searchBooks("author", value);
                } else if (i == 3) {
                    Scanner sc = new Scanner (System.in);
                    System.out.println("Podaj numer ISBN:");
                    String isbn = sc.nextLine();
                    System.out.println("Podaj tytuł:");
                    String title = sc.nextLine();
                    System.out.println("Podaj autora:");
                    String author = sc.nextLine();
                    System.out.println("Podaj rok wydania:");
                    String year = sc.nextLine();

                    db.addBook(isbn, title, author, year);
                } else {
                    break;
                }
            }
        }
    }
}
