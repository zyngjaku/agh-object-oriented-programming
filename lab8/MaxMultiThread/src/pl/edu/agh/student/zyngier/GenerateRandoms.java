package pl.edu.agh.student.zyngier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class GenerateRandoms {
    GenerateRandoms(String str){
        try {
            FileWriter fw = new FileWriter("randoms.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
