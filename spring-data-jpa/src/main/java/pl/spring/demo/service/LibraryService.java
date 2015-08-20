package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.LibraryTo;

public interface LibraryService {
	List<LibraryTo> findAllLibs();
	List<LibraryTo> findLibraryByName(String name);
	void deleteLibrary(Long id);
}
