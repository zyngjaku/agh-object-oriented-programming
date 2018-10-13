import java.util.List;

public class Main {

    public static void main(String[] args) {
        int number = JIn.getInt();

        List<Boolean> list = LiczbyPierwsze.znajdzLiczbyPierwsze(number);

        for(int i=2; i<=number; i++){
            if(list.get(i)) System.out.println(i);
        }
    }
}
