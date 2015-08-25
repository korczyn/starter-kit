angular.module('app.books').controller('BookModalController', function ($scope, Flash) {
    'use strict';

    $scope.book = [];
    $scope.title = '';
    $scope.authors = '';
    $scope.authorFirstName = '';
	$scope.authorLastName = '';
	

    $scope.addAuthor = function(authorFirstName, authorLastName) {
    	if(authorFirstName !== '' && authorLastName !== ''){
    		if($scope.authors === ''){
        		$scope.authors = authorFirstName + ' ' + authorLastName;
        	} else {
        		$scope.authors = $scope.authors + ', ' + authorFirstName + ' ' + authorLastName;
        	}
    		$scope.authorFirstName = '';
    		$scope.authorLastName = '';
    	} else {
    		Flash.create('danger', 'Fill all author inputs and click +', 'custom-class');
    	}
    };
    
    $scope.prepareReturn = function(newBookTitle, authors) {
    	$scope.book.push(newBookTitle);
    	$scope.book.push(authors);
    };
    
    
});