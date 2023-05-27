package com.example.BookProject.controller;

import com.example.BookProject.entity.Book;
import com.example.BookProject.repos.BookRepos;
import com.example.BookProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookRepos bookRepos;

    @GetMapping("/books")
    public String book(@RequestParam(name = "name", required = false, defaultValue = "Book name") String name,
                       Map<String, Object> model) {
        model.put("name", name);

        return "books";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Book> books = bookRepos.findAll(); // вывожу полный список книг
        model.put("AllBooks", books);

        return "main";


    }

    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable("id") Integer id, Model model) {
        //Переход на страницу книги
        Book book = bookRepos.findById(id).orElse(null);
        model.addAttribute("book", book);

        return "books";
    }
    @PostMapping()
    public String add(@RequestParam String name, @RequestParam String author, Map<String, Object> model) {
            Book book = new Book(name, author);  // добавляю новый объект
            bookRepos.save(book); //сохраняю его
        Iterable<Book> books = bookRepos.findAll(); //вывожу полный список
        model.put("AllBooks", books); //сохраняю в мапу
        return "main";

    }






}
