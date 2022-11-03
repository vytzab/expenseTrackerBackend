package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import javax.validation.Valid;

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
public class AuthController {
	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("User is logged in", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
}
