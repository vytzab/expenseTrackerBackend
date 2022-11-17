package lt.viko.eif.vytzab.expenseTrackerApi.entity;

/**
 * @author Vytautas
 *
 *         Class for the <JwtResponse> entity implementation.
 */
public class JwtResponse {

	private final String jwtToken;

	/**
	 * @param jwtToken
	 */
	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}

}
