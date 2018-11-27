package by.epam.mark.exception;

public class MarkException extends Exception {

    private static final long serialVersionUID = 9027438567122790285L;
	
    public MarkException() {
        super("Wromg mark");
    }

    public MarkException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MarkException(final String message) {
        super(message);
    }
	
    public MarkException(final Throwable cause) {
        super(cause);
    }
}
