package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;

public interface MyBookRepository {
	List<BookEntity> findBook(BookSearchCriteria crit);
}
