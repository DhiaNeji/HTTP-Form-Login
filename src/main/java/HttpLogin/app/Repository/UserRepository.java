package HttpLogin.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import HttpLogin.app.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User> findUserByUsername(String username);
}
