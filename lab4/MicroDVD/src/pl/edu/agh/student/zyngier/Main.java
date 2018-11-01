package pl.edu.agh.student.zyngier;

import java.io.IOException;

public class Main  {

    public static void main(String[] args) {

        try {
            MicroDVD.delay("input", "output", 1000, 45);
        }
        catch (BadFormatException e){
            //e.printStackTrace();
            e.getMessage();
        }
    }
}
