package hh.swd20.ExpTrack;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.ExpTrack.domain.Category;
import hh.swd20.ExpTrack.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Hobby");
		
		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Eläin");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Category category = new Category("Eläin");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
		
		repository.deleteById(category.getId());
		assertThat(repository.findById(category.getId())).isEmpty();
	}
}
