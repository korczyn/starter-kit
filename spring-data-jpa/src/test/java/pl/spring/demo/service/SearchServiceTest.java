package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class SearchServiceTest {

	@Autowired
	private SearchService searchService;

	@Test
	public void testShouldReturAllBooksWhenNoCriteria() {
		BookSearchCriteria crit = new BookSearchCriteria(null, null, null);

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(11, allBooks.size());
	}

	@Test
	public void shouldFindBooksIfOnlyLibraryNameProvided() {
		BookSearchCriteria crit = new BookSearchCriteria(null, null, "oss");

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(5, allBooks.size());
	}

	@Test
	public void shouldFindBooksIfOnlyTitleProvided() {
		BookSearchCriteria crit = new BookSearchCriteria("ewry", null, null);

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Ewrybady pomarancze", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksIfOnlyAuthorFirstNameProvided() {
		BookSearchCriteria crit = new BookSearchCriteria(null, "mis", null);

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksIfOnlyAuthorLastNameProvided() {
		BookSearchCriteria crit = new BookSearchCriteria(null, "gosp", null);

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksIfOnlyLibraryNameAbsent() {
		BookSearchCriteria crit = new BookSearchCriteria("round", "gosp", null);

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksIfOnlyTitleAbsent() {
		BookSearchCriteria crit = new BookSearchCriteria(null, "gosp", "bibl");

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksIfOnlyAuthorAbsent() {
		BookSearchCriteria crit = new BookSearchCriteria("round", null, "bibl");

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

	@Test
	public void shouldFindBooksWhenAllCriteriaProvided() {
		BookSearchCriteria crit = new BookSearchCriteria("round", "gosp", "bibl");

		List<BookTo> allBooks = searchService.findBook(crit);

		assertNotNull(allBooks);
		assertEquals(1, allBooks.size());
		assertEquals("Roundhouse Kick", allBooks.get(0).getTitle());
	}

}
