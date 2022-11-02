package lt.viko.eif.vytzab.expenseTrackerApi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;
import lt.viko.eif.vytzab.expenseTrackerApi.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public User createUser(UserModel user) {
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepo.save(newUser);
	}

}
