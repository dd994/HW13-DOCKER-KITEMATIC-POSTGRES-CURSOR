package edu.cursor.service;

import edu.cursor.repository.Author;
import edu.cursor.repository.Book;
import edu.cursor.repository.Genre;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibraryActionsImpl implements LibraryActions {

    private List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author(1, "Volodymyr", "Malyk"),
            new Author(2, "Jack", "London"),
            new Author(3, "Scott", "Walter"),
            new Author(4, "Pavlo", "Zagrebelniy")
    ));

    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, 1, "Чумацький шлях", Genre.STORY, "У новому історичному романі автор відображає цікаве й своєрідне явище в історії українського народу — чумацтво", 4.8),
            new Book(2, 2, "Північна Одіссея", Genre.STORY, "Збірник містить оповідання з Північного циклу Джека Лондона. Якось він написав: «Життя коротке, і я хочу взяти від кожного краще, що в ньому є...»", 4.8),
            new Book(3, 3, "Aйвенго", Genre.ROMAN, "Роман «Айвенго» — один із найкращих творів знаменитого письменника Вальтера Скотта. Цей роман був створений майже двісті років тому, а події, про які йдеться, відбувались у XII столітті.", 4.8),
            new Book(4, 4, "Попіл снів", Genre.DETECTIVE, "У новорічну ніч на пульт управління саркофагом АЕС вривається невідома жінка в генеральській формі й заявляє, що залишиться тут доти, поки до неї не прибудуть із Києва представники влади.", 4.8)
    ));

    @Override
    public List<Author> getAuthors(){
        return  authors;
    }

    @Override
    public List<Book> getBooks(){
        return  books;
    }

    @Override
    public List<Author> addAuthor(Author author) {
        authors.add(author);
        return authors;
    }

    @Override
    public List<Author> addBook(Book book) {
        books.add(book);
        return authors;
    }

    @Override
    public List<Book> sortBookByGenre(String genre) {
        Genre genreEnum = null;
        genre.toLowerCase();

        switch (genre){
            case ("story"):
                genreEnum = Genre.STORY;
                break;
            case ("comedy"):
                genreEnum = Genre.COMEDY;
                break;
            case ("detective"):
                genreEnum = Genre.DETECTIVE;
                break;
            case ("roman"):
                genreEnum = Genre.ROMAN;
                break;
        }

        Genre finalGenreEnum = genreEnum;
        return books.stream()
                .filter(book -> book.getGenre().equals(finalGenreEnum))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
    }

    @Override
    public void refreshBook(int idOldBook, Book newBook) {
        books.remove(idOldBook);
        books.add(newBook);
    }

    @Override
    public List<Book> sortBookByAuthor(String authorLastName) {
        int id= 0;
        for (Author author: authors) {
            if (author.getLName().equals(authorLastName)){
                id = author.getId();
            }
        }
        int finalId = id;
        return books.stream()
                .filter(book -> book.getAuthorId()== finalId)
                .collect(Collectors.toList());
    }

}
