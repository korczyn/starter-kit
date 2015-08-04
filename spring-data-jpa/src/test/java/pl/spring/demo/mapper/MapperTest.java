package pl.spring.demo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import pl.spring.demo.common.Mapper;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

public class MapperTest {

	private Mapper mapper;
	
	@org.junit.Before
	public void setUp(){
		mapper = new Mapper();
	}
	
	@Test
	public void convertBookToToBookEntity() {
		BookTo book = new BookTo(1L, "title", "Jan Kawa, Marek Siudym");
		BookEntity result = mapper.convert(book);
		assertEquals(1L, result.getId().longValue());
		assertEquals("title", result.getTitle());
		assertEquals("Jan Kawa", result.getAuthor().get(0).getFirstName() + " " + result.getAuthor().get(0).getLasteName());
		assertEquals("Marek Siudym", result.getAuthor().get(1).getFirstName() + " " + result.getAuthor().get(1).getLasteName());
	}
	
	@Test
	public void convertBookEntityToBookTo(){
		BookEntity book = new BookEntity(1L, "title", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Jan", "Kawa"))));
		BookTo result = mapper.convert(book);
		assertEquals(1L, result.getId().longValue());
		assertEquals("title", result.getTitle());
		assertEquals(book.getAuthor().get(0).getFirstName() + " " + book.getAuthor().get(0).getLasteName(), result.getAuthors());
	}

}
