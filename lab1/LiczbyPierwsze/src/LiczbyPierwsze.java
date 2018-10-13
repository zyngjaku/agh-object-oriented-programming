import java.util.*;

public class LiczbyPierwsze {
    public static List<Boolean> znajdzLiczbyPierwsze(int number) {
        List<Boolean> list = new ArrayList<Boolean>(Arrays.asList(new Boolean[number]));
        Collections.fill(list, Boolean.TRUE);

        for(int i=2; i<=Math.sqrt(number); i++) {
            for(int j=i+i; j<=number; j=j+i) {
                list.set(j,false);
            }
        }

        return list;
    }
}
