package tp;

/*
 * si extends Exception , MyArithmeticException est à try/catch obligatoire "check exception"
 * si extends RuntimeException , MyArithmeticException est à try/catch facultatif "uncheck exception"
 */

//public class MyArithmeticException extends Exception {
public class MyArithmeticException extends RuntimeException {

	public MyArithmeticException() {
		// TODO Auto-generated constructor stub
	}

	public MyArithmeticException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyArithmeticException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MyArithmeticException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyArithmeticException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
