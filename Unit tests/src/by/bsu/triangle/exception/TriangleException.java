package by.bsu.triangle.exception;
/**
 * The Class TriangleException.
 */
public class TriangleException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4899404863261061583L;

	/**
	 * Instantiates a new triangle exception.
	 */
	public TriangleException() {
		super();
	}

	/**
	 * Instantiates a new triangle exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public TriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new triangle exception.
	 *
	 * @param message the message
	 */
	public TriangleException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new triangle exception.
	 *
	 * @param cause the cause
	 */
	public TriangleException(Throwable cause) {
		super(cause);
	}

}
