angular.module('app.component1').factory('authorRestService', function ($http, currentContextPath) {
	'use strict';
	return {
		search: function () {
			return $http.get(currentContextPath.get() + 'rest/authors/author');
		}
	};
});