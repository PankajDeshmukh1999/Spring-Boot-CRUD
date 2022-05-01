package exception;

import javassist.SerialVersionUID;

public class APIException extends RuntimeException {
	
	private static final long SerialVersionUID=1l;
	public APIException (String message) {
		super(message);
	}

}
