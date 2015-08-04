package pl.spring.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import pl.spring.demo.common.Mapper;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.impl.BookDaoImpl;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

public class BookDaoImplTest {

	private Set<BookEntity> aaa;
	
	@InjectMocks
	private BookDaoImpl bookDao;
	@Mock
	private Mapper mapper;
	@Mock
	private Sequence sequence;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		aaa = new HashSet<>(bookDao.findAll());
	}


	@Test
    public void testShouldFindAllBooksByTitle() {
        // given
        final String title = "r";
        // when
        List<BookEntity> booksByTitle = bookDao.findBookByTitle(title);
        // then
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
    }

	@Test
	public void testShouldFindAllBooksByAuthor() {
		// given
		final String author = "Jan Paran";
		// when
		List<BookEntity> booksByAuthor = bookDao.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}
	
	@Test
	public void testShouldFindAllBooks() {
		// when
		List<BookEntity> allBooks = bookDao.findAll();
		// then
		assertNotNull(allBooks);
		assertFalse(allBooks.isEmpty());
		assertEquals(6, allBooks.size());
	}
}
