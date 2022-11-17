package lt.viko.eif.vytzab.expenseTrackerApi.services;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;

/**
 * @author Vytautas
 *
 *         Interface to outline operations with <User> objects.
 */
public interface IUserService {

	User createUser(UserModel userModel);

	User readUser();

	User updateUser(UserModel userModel);

	void deleteUser();

	User getLoggedInUser();
}
