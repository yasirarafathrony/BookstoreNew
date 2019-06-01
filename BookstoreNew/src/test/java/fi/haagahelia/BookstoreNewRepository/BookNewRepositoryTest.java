package fi.haagahelia.BookstoreNewRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.BookstoreNew.domain.BookNewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookNewRepositoryTest {

	@Autowired
	private BookNewRepository repository;
	
	@Test
	public void findByLastnameShouldReturnBookNew() {
		List<BookNew> books = repository.findByLastName("Farm");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getFirstName()).isEqualTo("Animal");
		
	}
}
