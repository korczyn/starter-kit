angular.module('app.component1').factory('authorService', function (authorRestService) {
    'use strict';
    
    return {
    	search: function () {
    		return authorRestService.search();
    	}
    };
});