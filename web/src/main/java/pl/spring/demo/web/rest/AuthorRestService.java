package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.service.AuthorService;

@RestController(value = "/rest")
public class AuthorRestService {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public List<AuthorEntity> findAllAuthors(){
		return authorService.findAllAuthors();
	}
	
}
