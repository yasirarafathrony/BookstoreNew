package fi.haagahelia.BookstoreNew.domain;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.BookstoreNew.List;

public interface BookNewRepository extends CrudRepository<BookNew, Integer>{

	List<fi.haagahelia.BookstoreNew.BookNew> findByLastName(String string);

}
