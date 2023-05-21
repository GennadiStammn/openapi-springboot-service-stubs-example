package com.example.demo.service;

import com.example.springreactiveopenapicodegen.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO createBook(BookDTO bookDTO);
    BookDTO deleteBook(String id);

    List<BookDTO> getAllBook();

    BookDTO getOneBook(String id);

    BookDTO updateBook(BookDTO bookDTO);

}
