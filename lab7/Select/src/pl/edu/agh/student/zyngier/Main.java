package pl.edu.agh.student.zyngier;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        db.connect();
        db.getBooks();
    }
}
