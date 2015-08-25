angular.module('app.books').factory('bookRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return $http.get(currentContextPath.get() + 'rest/books/books-by-title', {params: {titlePrefix: titlePrefix}});
        },
        deleteBook: function (bookId) {
            return $http.delete(currentContextPath.get() + 'rest/books/book/' + bookId);
        },
        changeBookTitle: function (bookId, titlePrefix){
        	return $http.post(currentContextPath.get() + 'rest/books/bookch/' + bookId + '/' + titlePrefix);
        },
        addBook: function (json){
        	return $http.post(currentContextPath.get() + 'rest/books/addBook/', json);
        }
    };
});
