package pl.spring.demo.aop;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.impl.BookDaoImpl;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.IdAware;

@Component
public class BookDaoAdvisor implements MethodBeforeAdvice {
	private Set<BookEntity> setOfBooks;

	@Override
	public void before(Method method, Object[] objects, Object o) throws Throwable {
		BookDaoImpl bookDao = (BookDaoImpl) o;
		setOfBooks = new HashSet<>(bookDao.findAll());
		if (hasAnnotation(method, o, NullableId.class)) {
			checkNotNullId(objects[0]);
		}
	}

	private void checkNotNullId(Object o) {
		if (o instanceof IdAware && ((IdAware) o).getId() != null) {
			throw new BookNotNullIdException();
		}

		if (o instanceof BookEntity) {
			BookEntity book = (BookEntity) o;
			if (book.getId() == null) {
				Sequence sequence = new Sequence();
				book.setId(sequence.nextValue(setOfBooks));
			}
		}
	}

	private boolean hasAnnotation(Method method, Object o, Class annotationClazz) throws NoSuchMethodException {
		boolean hasAnnotation = method.getAnnotation(annotationClazz) != null;

		if (!hasAnnotation && o != null) {
			hasAnnotation = o.getClass().getMethod(method.getName(), method.getParameterTypes())
					.getAnnotation(annotationClazz) != null;
		}
		return hasAnnotation;
	}
}
