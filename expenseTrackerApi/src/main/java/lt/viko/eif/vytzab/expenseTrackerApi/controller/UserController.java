package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.User;
import lt.viko.eif.vytzab.expenseTrackerApi.entity.UserModel;
import lt.viko.eif.vytzab.expenseTrackerApi.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

}
