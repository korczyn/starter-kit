describe('author service', function() {
	'use strict';
	var  authorService;
	
	beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.component1');
    });
	
	beforeEach(function() {
		inject(function($injector) {
			authorService = $injector.get('authorService');
		});
	});

	it('authorService.search should call authorRestService.search', inject(function ($q, authorRestService) {
		var deferred = $q.defer();
		spyOn(authorRestService, 'search').and.returnValue(deferred.promise);
		authorService.search();
		expect(authorRestService.search).toHaveBeenCalledWith();
	}));
});