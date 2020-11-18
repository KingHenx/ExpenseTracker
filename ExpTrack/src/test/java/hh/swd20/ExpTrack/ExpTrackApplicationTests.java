package hh.swd20.ExpTrack;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.ExpTrack.web.CategoryController;
import hh.swd20.ExpTrack.web.PurchaseController;

@RunWith(SpringRunner.class)
@SpringBootTest
class ExpTrackApplicationTests {

	@Autowired
	private PurchaseController pController;
	
	@Autowired
	private CategoryController cController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(pController).isNotNull();
		assertThat(cController).isNotNull();
	}

}
