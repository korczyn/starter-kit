package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

	@Autowired
	private BookService bookService;

	@Test
	public void shouldSaveBook(){
		BookTo book = new BookTo(null, "title", "janek kawa");
		List<BookTo> allBooks = bookService.findAllBooks();
		System.out.println("aaaa " + allBooks.size());
		BookTo result = bookService.saveBook(book);
		System.out.println("KAAAAWAAAA " + result.getId());
	}
	
	@Test
	public void testShouldFindAllBooks() {
		// when
		List<BookTo> allBooks = bookService.findAllBooks();
		// then
		assertNotNull(allBooks);
		assertFalse(allBooks.isEmpty());
		assertEquals(7, allBooks.size());
	}

	@Test
	public void testShouldFindAllBooksByTitle() {
		// given
		final String title = "r";
		// when
		List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
		// then
		System.out.println(booksByTitle);
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByAuthor() {
		// given
		final String author = "siudym";
		// when
		List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}

	@Test(expected = BookNotNullIdException.class)
	public void testShouldThrowBookNotNullIdException() {
		// given
		final BookTo bookToSave = new BookTo();
		bookToSave.setId(22L);
		// when
		bookService.saveBook(bookToSave);
		// then
		fail("test should throw BookNotNullIdException");
	}
}
