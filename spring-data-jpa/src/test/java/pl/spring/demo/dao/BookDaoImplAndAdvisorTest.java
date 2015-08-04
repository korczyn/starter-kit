package pl.spring.demo.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class BookDaoImplAndAdvisorTest {

	
	@Autowired
	private BookDao	bookDao;
	
	@Test
	public void shouldSaveBook() {
		BookEntity book = new BookEntity();
		
		BookEntity result = bookDao.save(book);
		
		assertEquals(7L, result.getId().longValue());
	}
	
}
