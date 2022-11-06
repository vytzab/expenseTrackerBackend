package lt.viko.eif.vytzab.expenseTrackerApi.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User existingUser = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for email " + email));
		return new org.springframework.security.core.userdetails.User(existingUser.getEmail(),
				existingUser.getPassword(), new ArrayList<>());
	}

}
