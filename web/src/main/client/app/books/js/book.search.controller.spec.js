describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.books');
    });
    
    beforeEach(function(){
    	module('ngMockE2E');
    });
    
    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));
    
    
    it('changeTitleById should change title in scope.books', function ($controller) {
    	//given
    	$controller('BookSearchController', {$scope: $scope});
    	$scope.books = [{id: 1, title: 'jeden', authors: []}];
    	//when
    	$scope.changeTitleById(1, 'konik');
    	//then
    	expect($scope.books[0].title).toBe('konik');
    	
    });

    it('addBookToScope should add book to scope.books', function ($controller) {
    	//given
    	$controller('BookSearchController', {$scope: $scope});
    	$scope.books = [];
    	//when
    	$scope.addBookToScope(1, 'konik', 'marek lol');
    	//then
    	expect($scope.books.length).toBe(1);
    	expect($scope.books[0].title).toBe('konik');
    });

    it('search is defined', inject(function ($controller) {
        // when
        $controller('BookSearchController', {$scope: $scope});
        // then
        expect($scope.search).toBeDefined();
    }));

    it('delete is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.deleteBook).toBeDefined();
    }));
    
    it('addBook is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.addBook).toBeDefined();
    }));
   
    it('changeTitle is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.changeBookTitle).toBeDefined();
    }));
    

    it('delete book should call bookService.deleteBook', inject(function ($controller, $q, bookService, Flash) {
        // given
        $controller('BookSearchController', {$scope: $scope});

        var bookId = 1;
        $scope.books = [{id: bookId, title: 'test'}];
        var deleteDeferred = $q.defer();
        spyOn(bookService, 'deleteBook').and.returnValue(deleteDeferred.promise);
        spyOn(Flash, 'create');
        // when
        $scope.deleteBook(bookId);
        deleteDeferred.resolve();
        $scope.$digest();
        // then
        expect(bookService.deleteBook).toHaveBeenCalledWith(bookId);
        expect(Flash.create).toHaveBeenCalledWith('success', 'Book has been removed', 'custom-class');
        expect($scope.books.length).toBe(0);
    }));
    
    it('search book should call bookService.searchBook', inject(function ($controller, $q, bookService){
    	//given
    	$controller('BookSearchController', {$scope: $scope});
    	var bookPrefix = 'P';
    	var bookId = 1;
    	var bookId2 = 2;
    	$scope.books = [];
    	var searchDeferred = $q.defer();
    	spyOn(bookService, 'search').and.returnValue(searchDeferred.promise);
    	//when
    	$scope.search(bookPrefix);
    	searchDeferred.resolve({data: [{id: bookId, title: 'Pierwsza', authors: []}, {id: bookId2, title: 'Druga'}]});
    	$scope.$digest();
    	//then
    	expect(bookService.search).toHaveBeenCalledWith(bookPrefix);
    	expect($scope.books.length).toBe(2);
    }));
    
    it('change title should call bookService.changeBookTitle', inject(function ($modal, $controller, $q, bookService){
    	//given
    	$controller('BookSearchController', {$scope: $scope, $modal: $modal});
    	var bookId = 1;
    	var bookTitle = 'Pierwsza';
    	$scope.books = [];
    	var book = {id: bookId, title: bookTitle};
    	var newTitle = 'ddd';
    	$scope.books.push(book);
    	var changeDeferred = $q.defer();
    	spyOn(bookService, 'changeBookTitle').and.returnValue(changeDeferred.promise);
    	
    	var modalInstance = {
    			result: {
    				then: function() {
    					bookService.changeBookTitle(book.id, newTitle).then(function () {
    						for (var i = 0; i < $scope.books.length; i = i + 1) {
    				    		if($scope.books[i].id === bookId){
    				    			$scope.books[i].title = newTitle;
    				    			break;
    				    		}
    				    	}
    					});
    				}
    			}
    	};
    	spyOn($modal, 'open').and.returnValue(modalInstance);
    	
    	//when
    	$scope.changeBookTitle(bookId, 'ddd');
    	changeDeferred.resolve();
    	$scope.$digest();
    	//then
    	expect(bookService.changeBookTitle).toHaveBeenCalledWith(bookId, 'ddd');
    	expect($scope.books[0].title).toBe(newTitle);
    	
    }));
   
    it('add book should call bookService.addBook', inject(function ($modal, $controller, $q, bookService){
    	//given
    	$controller('BookSearchController', {$scope: $scope, $modal: $modal});
    	var bookTitle = 'Pierwsza';
    	$scope.books = [];
    	var book = {title: bookTitle, authors: []};
    	var addDeferred = $q.defer();
    	spyOn(bookService, 'addBook').and.returnValue(addDeferred.promise);
    	
    	var text = '{ "title":"' + bookTitle + '", "authors": []}';
		var obj = JSON.parse(text);
    	
    	var modalInstance = {
    			result: {
    				then: function() {
    					bookService.addBook(book).then(function () {
    						$scope.books.push(book);
    					});
    				}
    			}
    	};
    	spyOn($modal, 'open').and.returnValue(modalInstance);
    	
    	//when
    	$scope.addBook();
    	addDeferred.resolve();
    	$scope.$digest();
    	//then
    	expect(bookService.addBook).toHaveBeenCalledWith(obj);
//    	
    }));
});
