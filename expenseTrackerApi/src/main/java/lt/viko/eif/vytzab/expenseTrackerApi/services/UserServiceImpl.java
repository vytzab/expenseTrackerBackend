package lt.viko.eif.vytzab.expenseTrackerApi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;
import lt.viko.eif.vytzab.expenseTrackerApi.exceptions.ItemExistsException;
import lt.viko.eif.vytzab.expenseTrackerApi.exceptions.ResourceNotFoundException;
import lt.viko.eif.vytzab.expenseTrackerApi.repositories.IUserRepository;

/**
 * @author Vytautas
 *
 *         Class for the operations with <User> objects implementation.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public User createUser(UserModel userModel) {
		if (userRepo.existsByEmail(userModel.getEmail())) {
			throw new ItemExistsException("User is already registered with email: " + userModel.getEmail());
		}
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User readUser() {
		return userRepo.findById(getLoggedInUser().getId()).orElseThrow(
				() -> new ResourceNotFoundException("User not found for the id: " + getLoggedInUser().getId()));
	}

	@Override
	public User updateUser(UserModel userModel) {
		User user = readUser();
		user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
		user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
		user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());
		user.setAge(userModel.getAge() != null ? userModel.getAge() : user.getAge());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public void deleteUser() {
		User user = readUser();
		userRepo.delete(user);
	}

	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for email " + email));
	}

}
