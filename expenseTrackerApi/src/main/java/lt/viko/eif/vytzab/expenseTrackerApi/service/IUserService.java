package lt.viko.eif.vytzab.expenseTrackerApi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;

public interface IUserService {

	User saveUser(UserModel user);

	Page<User> getUsers(Pageable page);

	User getUserById(Long id);

	User updateUser(UserModel user, Long id);

	void deleteUserById(Long id);
}
