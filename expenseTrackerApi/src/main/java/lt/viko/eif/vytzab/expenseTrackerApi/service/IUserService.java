package lt.viko.eif.vytzab.expenseTrackerApi.service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;

public interface IUserService {

	User createUser(UserModel user);
}
