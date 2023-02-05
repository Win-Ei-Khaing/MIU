package prog12_2;

public class OverdrawnAccountException extends Exception {

	public OverdrawnAccountException() {
		super();
	}

	public OverdrawnAccountException(String message) {
		super(message);
	}

	public OverdrawnAccountException(Throwable cause) {
		super(cause);
	}

}
