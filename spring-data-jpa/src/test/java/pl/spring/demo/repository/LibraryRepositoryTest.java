package pl.spring.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void testShouldReturnAllLibraries() {
		List<LibraryEntity> list = libraryRepository.findAllLibs();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	@Test
	public void testShouldFindLibraryByName(){
		final String libName = "Ossolineum";
		List<LibraryEntity> list = libraryRepository.findLibraryByName("Oss");
		assertNotNull(list);
		assertEquals(libName, list.get(0).getName());
	}
	
	@Test
	public void testShouldDeleteBooksFromLibrary(){
		LibraryEntity lib = new LibraryEntity(5L, "Moskwa");
		libraryRepository.save(lib);
		
		BookEntity book = new BookEntity(1L, "lawa");
		book.setLibrary(lib);
		bookRepository.save(book);
		BookEntity book2 = new BookEntity(2L, "dasd");
		book2.setLibrary(lib);
		bookRepository.save(book2);
		
		
		int preSize = bookRepository.findAll().size();
		libraryRepository.delete(5L);
		int postSize = bookRepository.findAll().size();
		
		assertTrue(postSize < preSize);
	}
	
}
