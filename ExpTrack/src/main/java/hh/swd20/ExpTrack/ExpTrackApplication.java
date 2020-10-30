package hh.swd20.ExpTrack;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.ExpTrack.domain.Category;
import hh.swd20.ExpTrack.domain.CategoryRepository;
import hh.swd20.ExpTrack.domain.Purchase;
import hh.swd20.ExpTrack.domain.PurchaseRepository;

@SpringBootApplication
public class ExpTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpTrackApplication.class, args);
	}
	//muista lisätä User Repository alle myöhemmin 
	@Bean
	public CommandLineRunner bookDemo(PurchaseRepository pRepository, CategoryRepository cRepository) {
		return(args) ->{
			
			Category x = new Category("Food");
			Category y = new Category("Hobby");
			Category z = new Category("Travel");
			
			cRepository.save(x);
			cRepository.save(y);
			cRepository.save(z);
			
			Purchase a = new Purchase("Bread", 1.59, "From fLidl", LocalDate.of(2020, 5, 4), x);
			Purchase b = new Purchase("Tennis Shoes", 45.99, "From Stadium", LocalDate.of(2020, 6, 12), x);
			Purchase c = new Purchase("Train Ticket", 6.98, "from VR, from Helsinki to Kouvola", LocalDate.of(2020, 10, 3), x);

			pRepository.save(a);
			pRepository.save(b);
			pRepository.save(c);
			

//			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
//			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
//			userRepository.save(user1);
//			userRepository.save(user2);
						
						
		};
	}

}
