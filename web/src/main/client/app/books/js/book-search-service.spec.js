describe('book service', function() {
	'use strict';
	var  bookService;
	
	beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.books');
    });
	
	beforeEach(function() {
		inject(function($injector) {
			bookService = $injector.get('bookService');
		});
	});

	it('bookService.deleteBook should call bookRestService.deleteBook', inject(function ($q, bookRestService) {
		var deleteDeferred = $q.defer();
		var bookId = 1;
		spyOn(bookRestService, 'deleteBook').and.returnValue(deleteDeferred.promise);
		bookService.deleteBook(bookId);
		expect(bookRestService.deleteBook).toHaveBeenCalledWith(bookId);
	}));

	it('bookService.search should call bookRestService.search', inject(function ($q, bookRestService) {
		var searchDeferred = $q.defer();
		var bookPrefix = 'P';
		spyOn(bookRestService, 'search').and.returnValue(searchDeferred.promise);
		bookService.search(bookPrefix);
		expect(bookRestService.search).toHaveBeenCalledWith(bookPrefix);
	}));

	it('bookService.add should call bookRestService.add', inject(function ($q, bookRestService) {
		var addDeferred = $q.defer();
		var bookId = 1;
		spyOn(bookRestService, 'addBook').and.returnValue(addDeferred.promise);
		bookService.addBook(bookId);
		expect(bookRestService.addBook).toHaveBeenCalledWith(bookId);
	}));

	it('bookService.changeTitle should call bookRestService.changeTitle', inject(function ($q, bookRestService) {
		var changeDeferred = $q.defer();
		var bookId = 1;
		var title = 'dd';
		spyOn(bookRestService, 'changeBookTitle').and.returnValue(changeDeferred.promise);
		bookService.changeBookTitle(bookId, title);
		expect(bookRestService.changeBookTitle).toHaveBeenCalledWith(bookId, title);
	}));
	
	

});