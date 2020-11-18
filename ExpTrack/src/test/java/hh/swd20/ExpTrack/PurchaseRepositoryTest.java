package hh.swd20.ExpTrack;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.ExpTrack.domain.Category;
import hh.swd20.ExpTrack.domain.Purchase;
import hh.swd20.ExpTrack.domain.PurchaseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PurchaseRepositoryTest {

	@Autowired
	private PurchaseRepository repository;
	
	@Test
	public void findByNameShouldReturnPurchase() {
		List<Purchase> purchases = repository.findByName("Tennis Shoes");
		
		assertThat(purchases).hasSize(1);
		assertThat(purchases.get(0).getPrice()).isEqualTo(45.99);
	}
	
	@Test
	public void createNewPurchase() {
		Purchase purchase = new Purchase("Rotta", 100.59, "From Faunatar", LocalDate.of(2020, 8, 4), new Category("Eläin"));
		repository.save(purchase);
		assertThat(purchase.getId()).isNotNull();

	}
	
	@Test
	public void deletePurchase() {
		Purchase purchase = new Purchase("Rotta", 100.59, "From Faunatar", LocalDate.of(2020, 8, 4), new Category("Eläin"));
		repository.save(purchase);
		assertThat(purchase.getId()).isNotNull();
		
		repository.deleteById(purchase.getId());
		assertThat(repository.findById(purchase.getId())).isEmpty();
	}
	
}
