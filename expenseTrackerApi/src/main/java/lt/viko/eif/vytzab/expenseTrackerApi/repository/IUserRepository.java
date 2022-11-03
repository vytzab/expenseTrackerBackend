package lt.viko.eif.vytzab.expenseTrackerApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	Boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
