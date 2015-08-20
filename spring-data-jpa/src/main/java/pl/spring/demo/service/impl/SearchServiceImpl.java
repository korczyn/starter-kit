package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.SearchService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookTo> findBook(BookSearchCriteria crit) {
		return BookMapper.map2To( bookRepository.findBooksBySearchCriteria(crit));
	}

}
