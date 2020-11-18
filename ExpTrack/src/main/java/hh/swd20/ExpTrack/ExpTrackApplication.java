package hh.swd20.ExpTrack;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import hh.swd20.ExpTrack.domain.Category;
import hh.swd20.ExpTrack.domain.CategoryRepository;
import hh.swd20.ExpTrack.domain.Purchase;
import hh.swd20.ExpTrack.domain.PurchaseRepository;
import hh.swd20.ExpTrack.domain.User;
import hh.swd20.ExpTrack.domain.UserRepository;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ExpTrackApplication{

	public static void main(String[] args) {
		SpringApplication.run(ExpTrackApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(PurchaseRepository pRepository, CategoryRepository cRepository, UserRepository uRepository) {
		return(args) ->{
			
			Category x = new Category("Food");
			Category y = new Category("Hobby");
			Category z = new Category("Travel");
			
			cRepository.save(x);
			cRepository.save(y);
			cRepository.save(z);
			
			//demo data of august-november
			
			//august
			Purchase a = new Purchase("Bread", 1.59, "From Lidl", LocalDate.of(2020, 8, 4), x);
			Purchase b = new Purchase("Tennis Shoes", 45.99, "From Stadium", LocalDate.of(2020, 8, 12), y);
			Purchase c = new Purchase("Train Ticket", 6.90, "from VR, from Helsinki to Kouvola", LocalDate.of(2020, 8, 3), z);
			Purchase d = new Purchase("Banana", 0.69, "From S-Market", LocalDate.of(2020, 8, 6), x);
			Purchase e = new Purchase("Ketchup", 3.79, "From S-Market", LocalDate.of(2020, 8, 6), x);
			//september
			Purchase f = new Purchase("Fancy Bread", 6.59, "From Stockman Herkku", LocalDate.of(2020, 9, 4), x);
			Purchase g = new Purchase("Cake", 15.99, "From Stockman Herkku", LocalDate.of(2020, 9, 12), x);
			Purchase h = new Purchase("HSL time", 66.90, "2 months of time to card", LocalDate.of(2020, 9, 3), z);
			Purchase i = new Purchase("apple", 0.50, "From S-Market", LocalDate.of(2020, 9, 6), x);
			Purchase j = new Purchase("Mayo", 2.79, "From S-Market", LocalDate.of(2020, 9, 6), x);
			//october
			Purchase k = new Purchase("Bread", 1.59, "From Lidl", LocalDate.of(2020, 10, 4), x);
			Purchase l = new Purchase("Miniature Train", 70.99, "From Hobbypoint", LocalDate.of(2020, 10, 12), y);
			Purchase m = new Purchase("Modelling Glue", 3.98, "from Hobbypoint", LocalDate.of(2020, 10, 3), y);
			Purchase n = new Purchase("Model Plane", 29.99, "From Hobbypoint", LocalDate.of(2020, 10, 6), y);
			Purchase o = new Purchase("Noodles", 3.79, "From S-Market", LocalDate.of(2020, 10, 6), x);
			//november
			Purchase p = new Purchase("Bread", 1.59, "From Lidl", LocalDate.of(2020, 11, 4), x);
			Purchase q = new Purchase("Plane ticket", 250.90, "To Canaria islands", LocalDate.of(2020, 11, 12), z);
			Purchase r = new Purchase("Train Ticket", 6.90, "from VR, from Helsinki to Kouvola", LocalDate.of(2020, 11, 3), z);
			Purchase s = new Purchase("Banana", 0.69, "From S-Market", LocalDate.of(2020, 11, 6), x);
			Purchase t = new Purchase("Ketchup", 3.79, "From S-Market", LocalDate.of(2020, 11, 6), x);



			pRepository.save(a);
			pRepository.save(b);
			pRepository.save(c);
			pRepository.save(d);
			pRepository.save(e);
			pRepository.save(f);
			pRepository.save(g);
			pRepository.save(h);
			pRepository.save(i);
			pRepository.save(j);
			pRepository.save(k);
			pRepository.save(l);
			pRepository.save(m);
			pRepository.save(n);
			pRepository.save(o);
			pRepository.save(p);
			pRepository.save(q);
			pRepository.save(r);
			pRepository.save(s);
			pRepository.save(t);
			

			//password on mestariostelija
			User user2 = new User("admin", "$2a$04$DBVoKdC9nAeRaCw5QvDO/Obi3T7wMaD3P3Q49yZy.8Yv9QVzMwPp.", "ADMIN");
			
			uRepository.save(user2);

						
						
		};
	}

}
