package pl.spring.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.repository.MyBookRepository;

public class BookRepositoryImpl implements MyBookRepository{

	@PersistenceContext(name = "hsql")
	private EntityManager entityManager;

	@Override
	public List<BookEntity> findBooksBySearchCriteria(BookSearchCriteria crit) {
		QBookEntity bookEntity = QBookEntity.bookEntity;
		JPAQuery query = new JPAQuery (entityManager);
		BooleanBuilder builder = new BooleanBuilder();
		List<BookEntity> list_bookEntity = new ArrayList<BookEntity>();

		if(crit.getAuthor() == null && crit.getLibraryName() == null && crit.getTitle() == null){
			list_bookEntity = query.from(bookEntity).list(bookEntity);
			return list_bookEntity;
		}
		
		if(crit.getTitle() != null){
			builder.and(bookEntity.title.startsWithIgnoreCase(crit.getTitle()));
		}
		
		if(crit.getAuthor() != null){
			BooleanBuilder authorBuilder = new BooleanBuilder();
			authorBuilder.or(bookEntity.authors.any().firstName.startsWithIgnoreCase(crit.getAuthor()));
			authorBuilder.or(bookEntity.authors.any().lastName.startsWithIgnoreCase(crit.getAuthor()));
			builder.and(authorBuilder);
		}
		
		if(crit.getLibraryName() != null){
			builder.and(bookEntity.library.libName.startsWithIgnoreCase(crit.getLibraryName()));
		}
		list_bookEntity = query.from(bookEntity).where(builder).list(bookEntity);		
		
		
		
		System.out.println(query.toString());
		
		return list_bookEntity;
	}
	
	

}
