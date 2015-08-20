angular.module('app.books').factory('bookRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return $http.get(currentContextPath.get() + 'rest/books-by-title', {params: {titlePrefix: titlePrefix}});
        },
        deleteBook: function (bookId) {
            return $http.delete(currentContextPath.get() + 'rest/book/' + bookId);
        },
        changeBookTitle: function (bookId, titlePrefix){
        	return $http.post(currentContextPath.get() + 'rest/bookch/' + bookId + '/' + titlePrefix);
        }
    };
});
