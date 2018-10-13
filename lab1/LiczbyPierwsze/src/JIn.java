import java.io.*;

public class JIn {
    public static int getInt() {
        int number = 0;

        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            String text = bfr.readLine();

            number = Integer.parseInt(text);
        }catch(IOException e){e.printStackTrace();}

        return number;
    }
}