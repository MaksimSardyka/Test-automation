package by.epam.mark.exception;

/**
 * Exception.
 */
public class MarkException extends Exception {

    private static final long serialVersionUID = 9027438567122790285L;

    /**
     * Default exception.
     */
    public MarkException() {
        super("Wromg mark");
    }

    /**
     * Parameterized exception.
     * 
     * @param message
     *            Message to show.
     * @param cause
     *            Cause of the exception.
     */
    public MarkException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized with message exception.
     * 
     * @param message
     *            Message to show.
     */
    public MarkException(final String message) {
        super(message);
    }

    /**
     * Parameterized with message cause.
     * 
     * @param cause
     *            Cause of the exception.
     */
    public MarkException(final Throwable cause) {
        super(cause);
    }
}
