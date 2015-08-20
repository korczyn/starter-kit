angular.module('app.books').factory('bookService', function (bookRestService) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return bookRestService.search(titlePrefix);
        },
        deleteBook: function (bookId) {
            return bookRestService.deleteBook(bookId);
        },
        changeBookTitle: function (bookId, titlePrefix) {
        	return bookRestService.changeBookTitle(bookId, titlePrefix);
        }
    };
});
