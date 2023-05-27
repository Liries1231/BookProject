package com.example.BookProject.repos;

import com.example.BookProject.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepos extends CrudRepository<Book, Integer> {



}
