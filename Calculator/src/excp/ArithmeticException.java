package excp;

public class ArithmeticException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArithmeticException(){
        System.out.println("ArithmeticException (e.g. divide by 0)");
    }

    public ArithmeticException(String blad){
        System.out.println(blad);
    }


}
