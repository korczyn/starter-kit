package pl.spring.demo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.to.LibraryTo;

public class LibraryMapper {

	public static LibraryTo map(LibraryEntity libraryEntity){
		if(libraryEntity != null){
			return new LibraryTo(libraryEntity.getId(), libraryEntity.getName(), mapBooks(libraryEntity.getBooks()));
		}
		return null;
	}
	
	public static LibraryEntity map(LibraryTo libraryTo){
		if(libraryTo != null){
			return new LibraryEntity(libraryTo.getId(), libraryTo.getName());
		}
		return null;
	}
	
	public static List<LibraryTo> map2To(List<LibraryEntity> libraryEntities) {
		return libraryEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
	}

	public static List<LibraryEntity> map2Entity(List<LibraryTo> libraryEntities) {
		return libraryEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
	}
	
	private static String mapBooks(Collection<BookEntity> books){
		if(!books.isEmpty()){
			return books.stream().map(bookEntity -> bookEntity.getTitle())
					.collect(Collectors.joining(", "));
		}
		return null;
	}
}
