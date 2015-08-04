package pl.spring.demo.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Mapper;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;

@Component
public class BookDaoImpl implements BookDao {

	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	@Autowired
	private Sequence sequence;

	@Autowired
	private Mapper mapper;

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		List<BookEntity> list = new ArrayList<BookEntity>();
		for (BookEntity book : ALL_BOOKS) {
			if (book.getTitle().toLowerCase().startsWith(title.toLowerCase())) {
				list.add(book);
			}
		}
		return list;
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String author) {
		List<BookEntity> list = new ArrayList<BookEntity>();
		String authorFullName;
		for (BookEntity book : ALL_BOOKS) {
			List<AuthorTo> authors = book.getAuthor();
			for (AuthorTo authorTo : authors) {
				authorFullName = authorTo.getFirstName() + " " + authorTo.getLasteName();
				if (authorFullName.toLowerCase().startsWith(author.toLowerCase())
						|| authorTo.getLasteName().toLowerCase().startsWith(author.toLowerCase())) {
					list.add(book);
				}
			}
		}
		return list;
	}

	@NullableId
	@Override
	public BookEntity save(BookEntity book) {
		ALL_BOOKS.add(book);
		return book;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "William", "Szekspir"), new AuthorTo(1L, "Marek", "Siudym")))));
		ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Hanna", "Ozogowska")))));
		ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Jan", "Parandowski")))));
		ALL_BOOKS.add(new BookEntity(4L, "Awantura w Nieklaju", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Edmund", "Niziurski")))));
		ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Zbigniew", "Nienacki")))));
		ALL_BOOKS.add(new BookEntity(6L, "Zemsta", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "Aleksander", "Fredro")))));
	}

}
