package org.example.ex5;

import org.example.ex5.entity.Author;
import org.example.ex5.entity.Book;
import org.example.ex5.utils.AuthorHelper;
import org.example.ex5.utils.BookHelper;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<Book>();
        Book bookOne = new Book("Book One");
        books.add(bookOne);
        Book bookTwo = new Book("Book Two");
        books.add(bookTwo);

        BookHelper bookHelper = new BookHelper();
        bookHelper.addBook(bookOne);
        bookHelper.addBook(bookTwo);

        Author authorOne = new Author("Taras", "Shevchenko");
        Author authorTwo = new Author("Ivan", "Franko");
        authorOne.setBooks(books);
        authorTwo.setBooks(books);

        AuthorHelper authorHelper = new AuthorHelper();
        authorHelper.addAuthor(authorOne);
        authorHelper.addAuthor(authorTwo);
    }
}
