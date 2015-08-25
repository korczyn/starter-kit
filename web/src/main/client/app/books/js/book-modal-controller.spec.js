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
    
    it('addAuthor is defined', inject(function ($controller) {
        // when
        $controller('BookModalController', {$scope: $scope});
        // then
        expect($scope.addAuthor).toBeDefined();
    }));
   
    it('prepareReturn is defined', inject(function ($controller) {
    	// when
    	$controller('BookModalController', {$scope: $scope});
    	// then
    	expect($scope.prepareReturn).toBeDefined();
    }));
    
    it('addAuthor should add author when authors empty', inject(function ($controller) {
    	$controller('BookModalController', {$scope: $scope});
        
        $scope.addAuthor('jan', 'koza');
        
    	expect($scope.authors).toBe('jan koza');
    }));
 
    it('addAuthor should add author to existing', inject(function ($controller) {
    	$controller('BookModalController', {$scope: $scope});
    	$scope.authors = 'marek kus';
    	
    	$scope.addAuthor('jan', 'koza');
    	
    	expect($scope.authors).toBe('marek kus, jan koza');
    }));
   
    it('prepare return should create an result array', inject(function ($controller) {
    	$controller('BookModalController', {$scope: $scope});
    	
    	$scope.authors = 'marek kus, jan koza';
    	$scope.prepareReturn('kamyki', $scope.authors);
    	
    	expect($scope.book.length).toBe(2);
    }));
});