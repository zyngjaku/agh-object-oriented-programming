package excp;

public class TooBigNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public TooBigNumberException(){
        System.out.println("TooBigNumberException");
    }

    public TooBigNumberException(String blad){
        System.out.println(blad);
    }
}
