package lt.viko.eif.vytzab.expenseTrackerApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;

/**
 * @author Vytautas
 *
 *         Interface to perform <User> JPA operations on an in-memory database.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	Boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

}
