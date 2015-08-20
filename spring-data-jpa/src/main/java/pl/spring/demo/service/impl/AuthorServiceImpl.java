package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.repository.AuthorRepository;
import pl.spring.demo.service.AuthorService;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorEntity> findAllAuthors() {
		return authorRepository.findAll();
	}

}
