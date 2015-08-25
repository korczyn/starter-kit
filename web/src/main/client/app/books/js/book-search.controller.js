angular.module('app.books').controller('BookSearchController', function ($scope, $window, $location, bookService, Flash, $modal) {
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
    		if($scope.books[i].id === bookId){
    			$scope.books[i].title = bookName;
    			break;
    		}
    	}
    };
    
    var addBookToScope = function(bookId, bookTitle, bookAuthors) {
    	var book = {id: bookId, title: bookTitle, authors: bookAuthors};
    	$scope.books.push(book);
    };
    
    $scope.search = function (bookPrefix) {
        bookService.search(bookPrefix).then(function (response) {
            angular.copy(response.data, $scope.books);
            Flash.create('success', 'Books with prefix "' + bookPrefix + '"', 'custom-class');
        }, function () {
            Flash.create('danger', 'Wyjątek', 'custom-class');
        });
    };

    $scope.deleteBook = function (bookId) {
        bookService.deleteBook(bookId).then(function () {
            removeBookById(bookId);
            Flash.create('success', 'Book has been removed', 'custom-class');
        });
    };
    
    
    $scope.addBook = function () {
    	var modalInstance = $modal.open({
    		templateUrl: 'books/html/book-modal-addBook.html',
    		controller: 'BookModalController',
    		size: 'lg',
    		resolve: {
                prefix: function () {
                  return $scope.prefix;
                },
                flash: function () {
                	return angular.copy(Flash);
                }
              }
    	});
    	
    	modalInstance.result.then(function (resultBook){
    		var text = '{ "title":"' + resultBook[0] + '", "authors": "' + resultBook[1] + '"}';
    		var obj = JSON.parse(text);
    		bookService.addBook(obj).then(function (response) {
    			addBookToScope(response.data.id, resultBook[0], resultBook[1]);
    			Flash.create('success', response.data.id + ' Book "' + resultBook[0] + '" with authors ' + resultBook[1] + ' has been added', 'custom-class');
    		});
    	});
    	
    };
    
    $scope.changeBookTitle = function (bookId) {
        var modalInstance = $modal.open({
            templateUrl: 'books/html/book-modal.html',
            controller: 'BookModalController',
            size: 'lg',
        });
        
        modalInstance.result.then(function (newTitle) {
        	bookService.changeBookTitle(bookId, newTitle).then(function () {
        		changeTitleById(bookId, newTitle);
        		Flash.create('success', 'Zmieniono tytul ksiazki ' + bookId + ' na ' + newTitle, 'custom-class');
        	});
          }, function () {
          });
    };
    
    
    

});
