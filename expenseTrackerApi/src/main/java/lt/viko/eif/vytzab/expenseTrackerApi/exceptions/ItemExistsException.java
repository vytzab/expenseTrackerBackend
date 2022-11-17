package lt.viko.eif.vytzab.expenseTrackerApi.exceptions;

/**
 * @author Vytautas
 *
 *         Class for the <ItemExistsException> exception implementation.
 */
public class ItemExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ItemExistsException(String message) {
		super(message);
	}
}
