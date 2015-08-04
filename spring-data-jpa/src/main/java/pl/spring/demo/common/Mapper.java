package pl.spring.demo.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Component
public class Mapper {

	public BookTo convert(BookEntity bookEntity){
		BookTo bt = new BookTo();
		List<AuthorTo> at = bookEntity.getAuthor();
		
		bt.setId(bookEntity.getId());
		bt.setTitle(bookEntity.getTitle());
		
		StringBuilder sb = new StringBuilder();
		for (AuthorTo authorTo : at) {
			sb.append(authorTo.getFirstName());
			sb.append(" ");
			sb.append(authorTo.getLasteName());
			sb.append(" ");
		}
		bt.setAuthors(sb.subSequence(0, sb.length() - 1).toString());
		
		
		return bt;
	}
	
	public BookEntity convert(BookTo bookTo){
		BookEntity be = new BookEntity();
		
		be.setId(bookTo.getId());
		be.setTitle(bookTo.getTitle());
		
		List<AuthorTo> authorsList = new ArrayList<AuthorTo>();
		if(bookTo.getAuthors() != null){
			String[] authors = bookTo.getAuthors().split(", ");
			for(int i = 0; i < authors.length; i++){
				String[] t = authors[i].split(" ");
				authorsList.add(new AuthorTo(bookTo.getId(), t[0], t[1]));
			}
			be.setAuthor(authorsList);
		}
		return be;
	}
	
	public List<BookTo> convertToBookToList(List<BookEntity> list){
		List<BookTo> bookToList = new ArrayList<BookTo>();
		for (BookEntity book : list) {
			bookToList.add(convert(book));
		}
		return bookToList;
	}
	
	public List<BookEntity> convertToBookEntityList(List<BookTo> list){
		List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
		for (BookTo book : list){
			bookEntityList.add(convert(book));
		}
		return bookEntityList;
	}
}
