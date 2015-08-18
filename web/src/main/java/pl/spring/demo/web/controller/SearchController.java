package pl.spring.demo.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.service.SearchService;
import pl.spring.demo.to.BookTo;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/byCrit", method = RequestMethod.GET)
	public String testing(
			@RequestParam(value = "t", required = false) String title,
			@RequestParam(value = "a", required = false) String author,
			@RequestParam(value = "l", required = false) String library,
			Map<String, Object> params) {
		final List<BookTo> allBooks = searchService.findBook(new BookSearchCriteria(title, author, library));
		params.put("books", allBooks);
		return "bookByCrit";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Map<String, Object> params){
		return "criteria";
	}
}
