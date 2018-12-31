package pl.edu.agh.student.zyngier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        boolean loop = true;

        try{
            while(loop) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Co chcesz zrobić?\n1. Pokaż osoby\n2. Dodaj osobe\n0. Wyjdź\n");

                String option = reader.readLine();

                switch (option) {
                    case "1": {
                        System.out.println("Wszystkie osoby w bazie danych:");
                        db.showPersons();
                        break;
                    }

                    case "2": {
                        System.out.println("Podaj dane osoby do dodania");

                        System.out.println("Nazwisko:");
                        String fullName = reader.readLine();

                        System.out.println("Telefon:");
                        String phone = reader.readLine();

                        System.out.println("PESEL:");
                        String pesel = reader.readLine();

                        db.addPerson(fullName, phone, pesel);

                        break;
                    }

                    case "0": {
                        System.out.println("Bye!");
                        loop = false;
                        break;
                    }

                    default: {
                        System.out.println("Nie ma takiej opcji!");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        db.showPersons();
        //db.addPerson("Jan Kowalski", "546345645", "95435634653");
        //db.showPersons();

    }
}
