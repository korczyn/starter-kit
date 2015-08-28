describe('book rest service', function () {
	'use strict';
	
	beforeEach(function () {
		module('app.main');
		module('app.books');
	});
	
	var scope, httpBackend, bookRestService;
	beforeEach(inject(function ($rootScope, _bookRestService_, $httpBackend) {
		scope = $rootScope.$new();
		httpBackend = $httpBackend;
		bookRestService = _bookRestService_;
	}));
	
	it('rest service should call GET on book search', function () {
		// given
		var prefix = 'test';
		var bookId = 1;
		var bookTitle = 'test1';
		var result = {data: [{id: bookId, title: bookTitle}]};
		// then
		httpBackend.expect('GET', '/context.html/rest/books/books-by-title?titlePrefix=' + prefix).respond(result);
		httpBackend.expect('GET', '/context.html/rest/books/books-by-title?titlePrefix=' + prefix).respond(200, 'success');
		// when
		bookRestService.search(prefix);
//		httpBackend.flush();
	});
	
	it('rest service should call DELETE on book deletion', function () {
		// given
		var bookId = 1;
		// then
		httpBackend.expect('DELETE', '/context.html/rest/books/book/' + bookId).respond();
		httpBackend.expect('DELETE', '/context.html/rest/books/book/' + bookId).respond(200, 'success');
		// when
		bookRestService.deleteBook(bookId);
//		httpBackend.flush();
	});
	
	it('rest service should call POST on title change', function () {
		//given
		var bookId = 1;
		var newBookTitle = 'koza';
		//when
		httpBackend.expect('POST', '/context.html/rest/books/bookch/' + bookId + '/' + newBookTitle).respond();
		httpBackend.expect('POST', '/context.html/rest/books/bookch/' + bookId + '/' + newBookTitle).respond(200, 'success');
		//then
		bookRestService.changeBookTitle(bookId, newBookTitle);
	});
	
	it('rest service should call POST on add book', function () {
		//given
		var bookTitle = 'test';
		var book = {title: bookTitle, authors: []};
		//when
		httpBackend.expect('POST', '/context.html/rest/books/addBook', book).respond();
		httpBackend.expect('POST', '/context.html/rest/books/addBook', book).respond(200, 'success');
		//then
		bookRestService.addBook(book);
		
	});
	
});