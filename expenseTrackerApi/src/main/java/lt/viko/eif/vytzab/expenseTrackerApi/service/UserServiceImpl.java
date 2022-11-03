package lt.viko.eif.vytzab.expenseTrackerApi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;
import lt.viko.eif.vytzab.expenseTrackerApi.exceptions.ItemAlreadyExistsException;
import lt.viko.eif.vytzab.expenseTrackerApi.exceptions.ResourceNotFoundException;
import lt.viko.eif.vytzab.expenseTrackerApi.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public User saveUser(UserModel userModel) {
		if (userRepo.existsByEmail(userModel.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered with email: " + userModel.getEmail());
		}
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Page<User> getUsers(Pageable page) {
		return userRepo.findAll(page);
	}

	@Override
	public User getUserById(Long id) throws ResourceNotFoundException {
		return userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for the id: " + id));
	}

	@Override
	public User updateUser(UserModel userModel, Long id) {
		User user = getUserById(id);
		user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
		user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
		user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());
		user.setAge(userModel.getAge() != null ? userModel.getAge() : user.getAge());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		User user = getUserById(id);
		userRepo.delete(user);
	}

}
