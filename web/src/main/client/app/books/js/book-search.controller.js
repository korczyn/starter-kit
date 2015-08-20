angular.module('app.books').controller('BookSearchController', function ($scope, $window, $location, bookService, Flash) {
    'use strict';

    $scope.books = [];
    $scope.gridOptions = { data: 'books' };
    $scope.prefix = '';

    var removeBookById = function (bookId) {
        for (var i = 0; i < $scope.books.length; i = i + 1) {
            if ($scope.books[i].id === bookId) {
                $scope.books.splice(i, 1);
                break;
            }
        }
    };
    
    var changeTitleById = function (bookId, bookName){
    	for (var i = 0; i < $scope.books.length; i = i + 1) {
    		if($scope.books[i].id == bookId){
    			$scope.books[i].title = bookName;
    			break;
    		}
    	}
    }
    
    $scope.search = function () {
        bookService.search($scope.prefix).then(function (response) {
            angular.copy(response.data, $scope.books);
        }, function () {
            Flash.create('danger', 'Wyjątek', 'custom-class');
        });
    };

    $scope.deleteBook = function (bookId) {
        bookService.deleteBook(bookId).then(function () {
            removeBookById(bookId);
            Flash.create('success', 'Książka została usunięta.', 'custom-class');
        });
    };
    
    $scope.changeBookTitle = function (bookId){
    	bookService.changeBookTitle(bookId, $scope.prefix).then(function () {
    		changeTitleById(bookId, $scope.prefix)
    		Flash.create('success', 'Zmieniono tytul ksiazki ' + bookId + ' na ' + $scope.prefix, 'custom-class');
    	});
    }

    $scope.addBook = function () {
        $location.url('/books/add-book');
    };
    
    

});
