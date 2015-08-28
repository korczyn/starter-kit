describe('author rest service', function () {
	'use strict';
	
	beforeEach(function () {
		module('app.main');
		module('app.component1');
	});
	
	var scope, httpBackend, authorRestService;
	beforeEach(inject(function ($rootScope, _authorRestService_, $httpBackend) {
		scope = $rootScope.$new();
		httpBackend = $httpBackend;
		authorRestService = _authorRestService_;
	}));
	
	it('rest service should call GET on author search', function () {
		// given
		var authorId = 1;
		var authorFirstName = 'jan';
		var authorLastName = 'koza';
		var result = {data: [{id: authorId, firstName: authorFirstName, lastName: authorLastName}]};
		// then
		httpBackend.expect('GET', '/context.html/rest/authors/author').respond(result);
		httpBackend.expect('GET', '/context.html/rest/authors/author').respond(200, 'success');
		// when
		authorRestService.search();
//		httpBackend.flush();
	});
});