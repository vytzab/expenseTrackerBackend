package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;
import lt.viko.eif.vytzab.expenseTrackerApi.services.IUserService;

/**
 * @author Vytautas
 *
 *         Class for the <User> methods REST implementation.
 */
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/profile")
	public ResponseEntity<User> getUser() {
		return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);
	}

	@PutMapping("/profile")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/deactivate")
	public ResponseEntity<HttpStatus> deleteUser() {
		userService.deleteUser();
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
