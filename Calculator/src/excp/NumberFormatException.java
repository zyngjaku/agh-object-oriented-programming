package excp;

public class NumberFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumberFormatException(){
        System.out.println("NumberFormatException");
    }

    public NumberFormatException(String blad){
        System.out.println(blad);
    }

}
