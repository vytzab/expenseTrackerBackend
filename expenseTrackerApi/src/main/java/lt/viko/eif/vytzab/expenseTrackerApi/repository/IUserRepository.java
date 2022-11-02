package lt.viko.eif.vytzab.expenseTrackerApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
