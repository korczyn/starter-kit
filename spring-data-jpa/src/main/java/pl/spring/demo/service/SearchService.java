package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface SearchService {
	public List<BookTo> findBook(BookSearchCriteria crit);
}
