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
    
    it('change title should call bookService.changeBookTitle', inject(function ($controller, $q, bookService){
    	//given
    	$controller('BookSearchController', {$scope: $scope});
    	var bookId = 1;
    	$scope.books = [{id: bookId, title: 'Pierwsza'}];
    	var changeDeferred = $q.defer();
//    	$httpBackend.whenGET('books/html/book-modal.html').respond('nowa');
    	spyOn(bookService, 'changeBookTitle').and.returnValue(changeDeferred.promise);
    	//when
    	bookService.changeBookTitle(bookId);
//    	changeDeferred.resolve(bookId, 'nowa');
    	changeDeferred.resolve({data: {id: bookId, title: 'nowa', authors: []}});
    	$scope.$digest();
    	//then
    	expect(bookService.changeBookTitle).toHaveBeenCalledWith(bookId);
    	
    }));
   
    it('add book should call bookService.addBook', inject(function ($controller, $q, bookService){
    	//given
    	$controller('BookSearchController', {$scope: $scope});
    	var bookId = 1;
    	$scope.books = [];
    	var addDeferred = $q.defer();
    	spyOn(bookService, 'addBook').and.returnValue(addDeferred.promise);
//    	
    	bookService.addBook(bookId);
    	addDeferred.resolve({data: {id: bookId, title: 'Pierwsza', authors: []}});
    	$scope.$digest();
    	
    	expect(bookService.addBook).toHaveBeenCalledWith(bookId);
//    	
    }));
});
