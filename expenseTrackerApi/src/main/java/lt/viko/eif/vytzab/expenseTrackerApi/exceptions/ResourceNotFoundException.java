package lt.viko.eif.vytzab.expenseTrackerApi.exceptions;

/**
 * @author Vytautas
 *
 *         Class for the <ItemExistsException> exception implementation.
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
