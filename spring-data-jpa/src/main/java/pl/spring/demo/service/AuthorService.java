package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.AuthorEntity;

public interface AuthorService {
	List<AuthorEntity> findAllAuthors();
}
