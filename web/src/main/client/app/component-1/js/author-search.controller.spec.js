describe('author controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.component1');
    });
    
    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));
    
    it('find is defined', inject(function ($controller) {
        // when
        $controller('AuthorSearchController', {$scope: $scope});
        // then
        expect($scope.find).toBeDefined();
    }));
    
    
    it('find authors should call authorService.search and succeed', inject(function ($controller, $q, authorService){
    	$controller('AuthorSearchController', {$scope: $scope});
    	$scope.authors = [];
    	var deferred = $q.defer();
    	spyOn(authorService, 'search').and.returnValue(deferred.promise);
    	
    	$scope.find();
    	deferred.resolve({ data: [{id: 1, firstName: 'jan', lastName: 'kon'}]});
    	$scope.$digest();
    	
    	expect($scope.authors.length).toBe(1);
    }));
    
});