package HttpLogin.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import HttpLogin.app.Entity.User;
import HttpLogin.app.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/hello")
	public String hello(Authentication a)
	{
		return "hello"+a.getName();
	}
}
