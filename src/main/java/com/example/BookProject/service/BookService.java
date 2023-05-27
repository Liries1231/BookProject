package com.example.BookProject.service;

import com.example.BookProject.entity.Book;
import com.example.BookProject.repos.BookRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepos bookRepos;

    public Page<Book> findAll(Pageable pageable) {
        return bookRepos.findAll(pageable);
    }

}
