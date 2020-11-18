package hh.swd20.ExpTrack;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.ExpTrack.domain.User;
import hh.swd20.ExpTrack.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("admin");
		
		assertThat(user).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		User user = new User("pekka", "$2a$04$DBVoKdC9nAeRaCw5QvDO/Obi3T7wMaD3P3Q49yZy.8Yv9QVzMwPk.", "USER");
		
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = new User("pekka", "$2a$04$DBVoKdC9nAeRaCw5QvDO/Obi3T7wMaD3P3Q49yZy.8Yv9QVzMwPk.", "USER");
		
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		
		repository.deleteById(user.getId());
		assertThat(repository.findById(user.getId())).isEmpty();
	}
}