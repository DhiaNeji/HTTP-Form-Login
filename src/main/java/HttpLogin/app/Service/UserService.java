package HttpLogin.app.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import HttpLogin.app.Entity.CustomUserDetails;
import HttpLogin.app.Entity.User;
import HttpLogin.app.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Supplier<UsernameNotFoundException> s =() -> new UsernameNotFoundException
				("Problem during authentication!");
				
		User u = userRepository.findUserByUsername(username).orElseThrow(s);
		
		return new CustomUserDetails(u);
	}
}
