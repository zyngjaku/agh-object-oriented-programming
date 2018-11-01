package pl.edu.agh.student.zyngier;

public class BadFormatException extends Exception {

    public BadFormatException(){
        System.out.println("BadFormatException");
    }

    public BadFormatException(String blad){
        System.out.println(blad);
    }
}
